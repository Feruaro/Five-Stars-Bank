package br.com.fivestarsbank.BlueBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fivestarsbank.BlueBank.models.Cliente;
import br.com.fivestarsbank.BlueBank.models.Endereco;
import br.com.fivestarsbank.BlueBank.models.DTO.EnderecoDTO;
import br.com.fivestarsbank.BlueBank.models.enums.StatusEnderecoContato;
import br.com.fivestarsbank.BlueBank.repositories.EnderecoRepository;
import br.com.fivestarsbank.BlueBank.service.exceptions.StatusInativoException;
import br.com.fivestarsbank.BlueBank.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repo;
	@Autowired
	private ClienteService cli_service;

	public Endereco buscar(Long id) {
		Optional<Endereco> endereco = repo.findById(id);
		return endereco.orElseThrow(() -> new ObjetoNaoEncontradoException("Endereço - Id: " + id));
	}

	private Endereco salvar(Endereco endereco) {
		return repo.save(endereco);
	}

	public List<Endereco> salvar(List<Endereco> lista) {
		return repo.saveAll(lista);
	}
	 
	public Endereco adicionar(Long id, EnderecoDTO end) {
		Cliente cliente = cli_service.buscar(id);
		Endereco endereco = converterDTO(end);
		
		endereco.setCliente(cliente);
		cliente.getEnderecos().add(endereco);

		endereco.setId(null);
		return salvar(endereco);
	}
	
	private Endereco converterDTO(EnderecoDTO end) {
		return new Endereco(end.getLogradouro(), end.getComplemento(), end.getBairro(), end.getCep(), end.getCidade(), end.getEstado(), end.getPais(), StatusEnderecoContato.toEnum(1));
	}

	public void inativarEndereco(Long id) {
		Endereco endereco = buscar(id);

		Cliente cliente = endereco.getCliente();
		Integer tam = qntdEnderecosInativos(cliente);

		if (endereco.getStatusEnd().getCod() == 2) {
			throw new StatusInativoException("Endereço", id);
		} else if (tam > 1) {
			endereco.setStatusEnd(StatusEnderecoContato.toEnum(2));
			salvar(endereco);
		} else {
			throw new StatusInativoException("endereço");
		}

	}

	private Integer qntdEnderecosInativos(Cliente cliente) {
		Integer tam = cliente.getEnderecos().size();
		Integer qntd = 0;

		for (int i = 0; i < tam; i++) {
			if (cliente.getEnderecos().get(i).getStatusEnd().getCod() == 2)
				qntd++;
		}

		return tam - qntd;
	}

}
