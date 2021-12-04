package br.com.fivestarsbank.BlueBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fivestarsbank.BlueBank.models.Cliente;
import br.com.fivestarsbank.BlueBank.models.Contato;
import br.com.fivestarsbank.BlueBank.models.DTO.ContatoDTO;
import br.com.fivestarsbank.BlueBank.models.enums.StatusEnderecoContato;
import br.com.fivestarsbank.BlueBank.repositories.ContatoRepository;
import br.com.fivestarsbank.BlueBank.service.exceptions.StatusInativoException;
import br.com.fivestarsbank.BlueBank.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repo;
	@Autowired
	private ClienteService cli_service;

	public Contato buscar(Long id) {
		Optional<Contato> contato = repo.findById(id);
		return contato.orElseThrow(() -> new ObjetoNaoEncontradoException("Contato - Id: " + id));
	}

	public List<Contato> listar() {
		return repo.findAll();
	}

	private Contato salvar(Contato contato) {
		return repo.save(contato);
	}

	public List<Contato> salvarLista(List<Contato> lista) {
		return repo.saveAll(lista);
	}

	public Contato adicionar(Long id, ContatoDTO contato) {
		Cliente cliente = cli_service.buscar(id);
		Contato cont = converterDTO(contato);

		cont.setCliente(cliente);
		cliente.getContatos().add(cont);

		cont.setId(null);
		return salvar(cont);
	}

	private Contato converterDTO(ContatoDTO contato) {
		return new Contato(contato.getTelefone(), contato.getContato_tel(), contato.getDescricao(), contato.getEmail(),
				StatusEnderecoContato.toEnum(1));
	}

	public void inativarContato(Long id) {
		Contato contato = buscar(id);

		Cliente cliente = contato.getCliente();
		Integer tam = qntdContatosInativos(cliente);

		if (contato.getStatusContato().getCod() == 2) {
			throw new StatusInativoException("Contato", id);
		} else if (tam > 1) {
			contato.setStatusContato(StatusEnderecoContato.toEnum(2));
			salvar(contato);
		} else {
			throw new StatusInativoException("contatos");
		}

	}

	private Integer qntdContatosInativos(Cliente cliente) {
		Integer tam = cliente.getContatos().size();
		Integer qntd = 0;

		for (int i = 0; i < tam; i++) {
			if (cliente.getContatos().get(i).getStatusContato().getCod() == 2) {
				qntd++;
			}
		}

		return tam - qntd;
	}

}
