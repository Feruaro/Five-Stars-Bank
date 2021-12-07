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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/contas")
public class ContaController {

	@Autowired
	private ContaService service;

	@ApiOperation(value = "Cadastra uma conta ao cliente informado")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Retorna uma string informando que o cadastro foi realizado"),
			@ApiResponse(code = 404, message = "Tratamento de exceção, retorna que o id informado não foi encontrado"),
			@ApiResponse(code = 500, message = "Erro")
	})
	@PostMapping(path = "/{id}")
	public ResponseEntity<String> cadastrar(@PathVariable Long id) {
		Conta conta = service.cadastrar(id);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(conta.getId()).toUri();
		String body = "Conta criada com sucesso!";
		return ResponseEntity.created(uri).body(body);
	}

	@ApiOperation(value = "Fecha a conta informada")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "sem retorno, atualiza o status da conta para inativa"),
			@ApiResponse(code = 404, message = "Tratamento de exceção, retorna que o id informado não foi encontrado"),
			@ApiResponse(code = 500, message = "Erro")
	})
	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> inativarConta(@PathVariable Long id) {
		service.inativarConta(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Retorna o extrato da conta em um determinado período de dias")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna o extrato da conta referente ao id informado em um determinado período de dias"),
			@ApiResponse(code = 404, message = "Tratamento de exceção, retorna que o id informado não foi encontrado"),
			@ApiResponse(code = 500, message = "Erro")
	})
	@GetMapping(path = "/{id}/{periodo}", produces = "application/json")
	public ResponseEntity<ExtratoDTO> exibirExtrato(@PathVariable Long id, @PathVariable Integer periodo) {
		ExtratoDTO extrato = service.exibirExtrato(id, periodo);
		return ResponseEntity.ok().body(extrato);
	}

}
