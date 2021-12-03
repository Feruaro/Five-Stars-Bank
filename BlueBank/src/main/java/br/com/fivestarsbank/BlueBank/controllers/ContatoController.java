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

import br.com.fivestarsbank.BlueBank.models.Contato;
import br.com.fivestarsbank.BlueBank.models.DTO.ContatoDTO;
import br.com.fivestarsbank.BlueBank.service.ContatoService;

@RestController
@RequestMapping(path = "/contatos")
public class ContatoController {

	@Autowired
	private ContatoService service;

	@PostMapping(path = "/{id}")
	public ResponseEntity<String> adicionar(@PathVariable Long id, @Valid @RequestBody ContatoDTO contato) {
		Contato cont = service.adicionar(id, contato);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cont.getId())
				.toUri();
		String body = "Contato adicionado com sucesso!";
		return ResponseEntity.created(uri).body(body);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> inativar(@PathVariable Long id) {
		service.inativarContato(id);
		return ResponseEntity.noContent().build();
	}
}
