package br.com.fivestarsbank.BlueBank.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fivestarsbank.BlueBank.models.Movimentacao;
import br.com.fivestarsbank.BlueBank.models.DTO.MovimentacaoDTO;
import br.com.fivestarsbank.BlueBank.service.MovimentacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/movimentacoes")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService service;
	
	@ApiOperation(value = "Retorna uma lista de movimentações da conta informada de forma paginada")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna lista de movimentações da conta referente ao id informado"),
			@ApiResponse(code = 500, message = "Erro")
	})
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Page<Movimentacao>> listar(@PathVariable Long id, Pageable pageable) {
		Page<Movimentacao> lista = service.listar(id, pageable);
		return ResponseEntity.ok().body(lista);
	}

	@ApiOperation(value = "Cadastra uma transação a conta informada. Além disso envia um e-mail do cliente com as informações da transação")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Retorna uma string informando que a transação foi realizada"),
			@ApiResponse(code = 400, message = "Tratamento de exceção, retorna que a conta referente ao id informado consta o status como inativa (não é possível cadastrar uma transação a uma conta inativa) ou retorna lista de erros informando o campo ou campos que possuem erros e os motivos"),
			@ApiResponse(code = 404, message = "Tratamento de exceção, retorna que o id informado não foi encontrado"),
			@ApiResponse(code = 500, message = "Erro")
	})
	@PostMapping(path = "/{id}", consumes = "application/json")
	public ResponseEntity<String> incluir(@RequestBody MovimentacaoDTO movi, @PathVariable Long id) {
		Movimentacao mov = service.incluir(movi, id);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mov.getId()).toUri();
		String body = "Transação realizada com sucesso!";
		return ResponseEntity.created(uri).body(body);
	}

}
