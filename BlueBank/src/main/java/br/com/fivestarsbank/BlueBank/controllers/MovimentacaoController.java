package br.com.fivestarsbank.BlueBank.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.fivestarsbank.BlueBank.service.SNSEmailService;

@RestController
@RequestMapping(path = "/movimentacoes")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService service;
	@Autowired
	private SNSEmailService sns_service;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<List<Movimentacao>> listar(@PathVariable Long id) {
		List<Movimentacao> lista = service.listar(id);
		return ResponseEntity.ok().body(lista);
	}

	@PostMapping(path = "/{id}")
	public ResponseEntity<String> incluir(@RequestBody MovimentacaoDTO movi, @PathVariable Long id) {
		Movimentacao mov = service.incluir(movi, id);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mov.getId()).toUri();

		sns_service.enviarEmail(sns_service.criarTopico(), service.gerarMensagemEmail(mov), service.gerarAssuntoEmail(mov));

		String body = "Transação realizada com sucesso!";
		return ResponseEntity.created(uri).body(body);
	}

}
