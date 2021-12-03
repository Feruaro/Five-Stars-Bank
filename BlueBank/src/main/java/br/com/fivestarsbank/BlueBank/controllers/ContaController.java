package br.com.fivestarsbank.BlueBank.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fivestarsbank.BlueBank.models.Conta;
import br.com.fivestarsbank.BlueBank.models.DTO.ExtratoDTO;
import br.com.fivestarsbank.BlueBank.service.ContaService;

@RestController
@RequestMapping(path = "/contas")
public class ContaController {

	@Autowired
	private ContaService service;

	@PostMapping(path = "/{id}")
	public ResponseEntity<String> cadastrar(@PathVariable Long id) {
		Conta conta = service.cadastrar(id);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(conta.getId()).toUri();
		String body = "Conta criada com sucesso!";
		return ResponseEntity.created(uri).body(body);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> inativarConta(@PathVariable Long id) {
		service.inativarConta(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(path = "/{id}/{periodo}")
	public ResponseEntity<ExtratoDTO> exibirExtrato(@PathVariable Long id, @PathVariable Integer periodo) {
		ExtratoDTO extrato = service.exibirExtrato(id, periodo);
		return ResponseEntity.ok().body(extrato);
	}

}
