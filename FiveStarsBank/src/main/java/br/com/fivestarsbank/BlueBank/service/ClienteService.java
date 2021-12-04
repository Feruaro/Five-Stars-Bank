package br.com.fivestarsbank.BlueBank.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fivestarsbank.BlueBank.models.Cliente;
import br.com.fivestarsbank.BlueBank.models.Conta;
import br.com.fivestarsbank.BlueBank.models.Contato;
import br.com.fivestarsbank.BlueBank.models.Endereco;
import br.com.fivestarsbank.BlueBank.models.DTO.ClienteDTO;
import br.com.fivestarsbank.BlueBank.models.DTO.ClienteDTO2;
import br.com.fivestarsbank.BlueBank.models.enums.StatusEnderecoContato;
import br.com.fivestarsbank.BlueBank.models.enums.TipoCliente;
import br.com.fivestarsbank.BlueBank.repositories.ClienteRepository;
import br.com.fivestarsbank.BlueBank.service.exceptions.ContaInativaException;
import br.com.fivestarsbank.BlueBank.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	@Autowired
	private EnderecoService end_service;
	@Autowired
	private ContatoService cont_service;
	@Autowired
	private SNSEmailService sns_service;

	public Cliente buscar(Long id) {
		Optional<Cliente> cliente = repo.findById(id);
		return cliente.orElseThrow(() -> new ObjetoNaoEncontradoException("Cliente - Id: " + id));
	}

	public List<Cliente> listar() {
		return repo.findAll();
	}
	
	public Page<Cliente> listarPage(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public Cliente salvar(Cliente cliente) {
		return repo.save(cliente);
	}

	private Cliente converterDTOCadastrar(ClienteDTO cliente) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Cliente cli = new Cliente(cliente.getNome(), cliente.getApelido(), TipoCliente.toEnum(cliente.getTipo()),
				cliente.getCpf_cnpj(), cliente.getRg_ie(), cliente.getGenero(),
				LocalDate.parse(cliente.getData_nascimento(), dtf));
		cli.setSenha(cliente.getSenha());

		Endereco end = new Endereco(cliente.getLogradouro(), cliente.getComplemento(), cliente.getBairro(),
				cliente.getCep(), cliente.getCidade(), cliente.getEstado(), cliente.getPais(),
				StatusEnderecoContato.toEnum(1));
		end.setCliente(cli);

		Contato cont = new Contato(cliente.getTelefone(), cliente.getContato_tel(), cliente.getDescricao(),
				cliente.getEmail(), StatusEnderecoContato.toEnum(1));
		cont.setCliente(cli);

		cli.getEnderecos().add(end);
		cli.getContatos().add(cont);

		return cli;
	}

	public Cliente cadastrar(ClienteDTO cli) {
		Cliente cliente = converterDTOCadastrar(cli);

		cliente.setId(null);
		salvar(cliente);
		
		//Criando topic e salvando no banco de dados | name = id do cliente;
		String arn = sns_service.criarTopico(cliente.getId());
		cliente.setTopico(arn);
		//Adicionando assinatura com protocolo "email" e o email cadastrado do cliente, no topic criado;
		sns_service.adicionarAssinaturaTopico(cliente, arn);
		
		salvar(cliente);
		
		end_service.salvar(cliente.getEnderecos());
		cont_service.salvarLista(cliente.getContatos());

		return cliente;
	}

	public void atualizar(ClienteDTO2 cliente, Long id) {
		Cliente cli = buscar(id);

		String nome = (cliente.getNome() == null) ? cli.getNome() : cliente.getNome();
		String apelido = (cliente.getApelido() == null) ? cli.getApelido() : cliente.getApelido();
		String genero = (cliente.getGenero() == null) ? cli.getGenero() : cliente.getGenero();

		cli.setNome(nome);
		cli.setApelido(apelido);
		cli.setGenero(genero);
		
		salvar(cli);
	}

	public void deletar(Long id) {
		Cliente cliente = buscar(id);

		if (!verificarContas(cliente)) { // verificar se o cliente possui contas ativas
			repo.deleteById(id);
		} else {
			throw new ContaInativaException();
		}

	}

	private boolean verificarContas(Cliente cliente) {
		for (Conta i : cliente.getContas()) {
			if (i.getStatus().getCod().equals(1)) {
				return true;
			}
		}

		return false;
	}

	public String mensagemEmail() {
		return "Seja bem-vindo(a) ao Five Stars Bank! \n\nCliente cadastrado com sucesso!";
	}

}
