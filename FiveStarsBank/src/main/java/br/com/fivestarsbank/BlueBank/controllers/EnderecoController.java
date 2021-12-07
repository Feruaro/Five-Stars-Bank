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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService service; 

	@ApiOperation(value = "Adiciona um endereço ao cliente informado")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Retorna uma string informando que o endereço foi adicionado as informações do cliente"),
			@ApiResponse(code = 400, message = "Tratamento de exceção / validação, retorna lista de erros informando o campo ou campos que possuem erros e os motivos"),
			@ApiResponse(code = 404, message = "Tratamento de exceção, retorna que o id informado não foi encontrado"),
			@ApiResponse(code = 500, message = "Erro")
	})
	@PostMapping(path = "/{id}", consumes = "application/json")
	public ResponseEntity<String> adicionar(@PathVariable Long id, @Valid @RequestBody EnderecoDTO endereco) {
		Endereco end = service.adicionar(id, endereco);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(end.getId()).toUri();
		String body = "Endereço adicionado com sucesso!";
		return ResponseEntity.created(uri).body(body);
	}

	@ApiOperation(value = "Inativa o endereço informado")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "sem retorno, atualiza o status do endereço para inativo"),
			@ApiResponse(code = 400, message = "Tratamento de exceção, retorna que o endereço referente ao id informado já consta o status como inativo ou é o único endereço ativo (cliente não pode ter zero endereços ativos)"),
			@ApiResponse(code = 404, message = "Tratamento de exceção, retorna que o id informado não foi encontrado"),
			@ApiResponse(code = 500, message = "Erro")
	})
	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> inativar(@PathVariable Long id) {
		service.inativarEndereco(id);
		return ResponseEntity.noContent().build();
	}

}
