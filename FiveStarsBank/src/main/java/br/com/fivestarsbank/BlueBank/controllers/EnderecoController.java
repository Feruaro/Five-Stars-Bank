package br.com.fivestarsbank.BlueBank.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fivestarsbank.BlueBank.models.Endereco;
import br.com.fivestarsbank.BlueBank.models.DTO.EnderecoDTO;
import br.com.fivestarsbank.BlueBank.service.EnderecoService;

@RestController
@RequestMapping(path = "/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService service; 

	@PostMapping(path = "/{id}")
	public ResponseEntity<String> adicionar(@PathVariable Long id, @Valid @RequestBody EnderecoDTO endereco) {
		Endereco end = service.adicionar(id, endereco);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(end.getId()).toUri();
		String body = "Endereço adicionado com sucesso!";
		return ResponseEntity.created(uri).body(body);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> inativar(@PathVariable Long id) {
		service.inativarEndereco(id);
		return ResponseEntity.noContent().build();
	}

}
