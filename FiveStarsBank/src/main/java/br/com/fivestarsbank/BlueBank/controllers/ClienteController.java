package br.com.fivestarsbank.BlueBank.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fivestarsbank.BlueBank.models.Cliente;
import br.com.fivestarsbank.BlueBank.models.DTO.ClienteDTO;
import br.com.fivestarsbank.BlueBank.models.DTO.ClienteDTO2;
import br.com.fivestarsbank.BlueBank.service.ClienteService;
import br.com.fivestarsbank.BlueBank.service.SNSEmailService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	@Autowired
	private SNSEmailService sns_service;

	@ApiOperation(value = "Retorna informações do cliente")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Retorna o cliente referente ao id informado"),
			@ApiResponse(code = 404, message = "Tratamento de exceção, retorna que o id informado não foi encontrado"),
			@ApiResponse(code = 500, message = "Erro")
	})
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
		Cliente cliente = service.buscar(id);
		return ResponseEntity.ok().body(cliente);
	}

	@ApiOperation(value = "Retorna informações de uma lista de clientes de forma paginada")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna lista de clientes"),
			@ApiResponse(code = 500, message = "Erro")
	})
	@GetMapping(produces = "application/json")
	public ResponseEntity<Page<Cliente>> listar(Pageable pageable) {
		Page<Cliente> listaCliente = service.listarPage(pageable);
		return ResponseEntity.ok().body(listaCliente);
	}

	@ApiOperation(value = "Cadastra um cliente, se todos os dados forem válidos. Além disso, cria um tópico e adiciona o e-mail do cliente como assinante de tópico. Cliente precisa confirmar no seu e-mail")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Retorna uma string informando que o cadastro foi realizado e com informações sobre o e-mail enviado"),
			@ApiResponse(code = 400, message = "Tratamento de exceção / validação, retorna lista de erros informando o campo ou campos que possuem erros e os motivos"),
			@ApiResponse(code = 500, message = "Erro")
	})
	@PostMapping(consumes = "application/json")
	public ResponseEntity<String> cadastrar(@Valid @RequestBody ClienteDTO cliente) {
		Cliente cli = service.cadastrar(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cli.getId()).toUri();

		String body = "Cadastro realizado com sucesso! \nConfirmação pendente, verifique seu e-mail: "
				+ cli.getContatos().get(0).getEmail();
		return ResponseEntity.created(uri).body(body);
	}

	@ApiOperation(value = "Envia um e-mail a um cliente")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna que o e-mail foi enviado! E-mail com informações sobre  cadastro do cliente"),
			@ApiResponse(code = 404, message = "Tratamento de exceção, retorna que o id informado não foi encontrado"),
			@ApiResponse(code = 500, message = "Erro")
	})
	@GetMapping(path = "/snsEmail/{id}")
	public ResponseEntity<String> enviarEmail(@PathVariable Long id) {
		Cliente cli = service.buscar(id);
		sns_service.enviarEmailCliente(cli.getTopico(), service.mensagemEmail(), "Five Stars Bank");
		String body = "E-mail enviado com sucesso!";
		return ResponseEntity.ok().body(body);
	}

	@ApiOperation(value = "Atualiza algumas informações do cliente")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "sem retorno, informações foram atualizadas com sucesso"),
			@ApiResponse(code = 400, message = "Tratamento de exceção / validação, retorna lista de erros informando o campo ou campos que possuem erros e os motivos"),
			@ApiResponse(code = 404, message = "Tratamento de exceção, retorna que o id informado não foi encontrado"),
			@ApiResponse(code = 500, message = "Erro")
	})
	@PutMapping(path = "/{id}", consumes = "application/json")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteDTO2 cliente) {
		service.atualizar(cliente, id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Deleta todas as informações do cliente")
	@ApiResponses(value = { 
			@ApiResponse(code = 204, message = "sem retorno, informações foram deletas com sucesso"),
			@ApiResponse(code = 400, message = "Tratamento de exceção, retorna que o cliente do id informado possui contas ativas, para deletar um cliente todas as contas vinculadas ao mesmo precisam estar inativas"),
			@ApiResponse(code = 404, message = "Tratamento de exceção, retorna que o id informado não foi encontrado"),
			@ApiResponse(code = 500, message = "Erro")
	})
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
