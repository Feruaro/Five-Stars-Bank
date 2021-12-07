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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/contatos")
public class ContatoController {

	@Autowired
	private ContatoService service;

	@ApiOperation(value = "Adiciona um contato ao cliente informado")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Retorna uma string informando que o contato foi adicionado as informações do cliente"),
			@ApiResponse(code = 400, message = "Tratamento de exceção / validação, retorna lista de erros informando o campo ou campos que possuem erros e os motivos"),
			@ApiResponse(code = 404, message = "Tratamento de exceção, retorna que o id informado não foi encontrado"),
			@ApiResponse(code = 500, message = "Erro")
	})
	@PostMapping(path = "/{id}", consumes = "application/json")
	public ResponseEntity<String> adicionar(@PathVariable Long id, @Valid @RequestBody ContatoDTO contato) {
		Contato cont = service.adicionar(id, contato);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cont.getId())
				.toUri();
		String body = "Contato adicionado com sucesso!";
		return ResponseEntity.created(uri).body(body);
	}

	@ApiOperation(value = "Inativa o contato informado")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "sem retorno, atualiza o status do contato para inativo"),
			@ApiResponse(code = 400, message = "Tratamento de exceção, retorna que o contato referente ao id informado já consta o status como inativo ou é o único contato ativo (cliente não pode ter zero contatos ativos)"),
			@ApiResponse(code = 404, message = "Tratamento de exceção, retorna que o id informado não foi encontrado"),
			@ApiResponse(code = 500, message = "Erro")
	})
	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> inativar(@PathVariable Long id) {
		service.inativarContato(id);
		return ResponseEntity.noContent().build();
	}
}
