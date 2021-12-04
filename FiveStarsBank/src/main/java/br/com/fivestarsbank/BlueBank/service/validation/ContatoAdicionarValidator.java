package br.com.fivestarsbank.BlueBank.service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import br.com.fivestarsbank.BlueBank.controllers.exceptions.FieldMessage;
import br.com.fivestarsbank.BlueBank.models.Contato;
import br.com.fivestarsbank.BlueBank.models.DTO.ContatoDTO;
import br.com.fivestarsbank.BlueBank.service.ContatoService;

public class ContatoAdicionarValidator implements ConstraintValidator<ContatoAdicionar, ContatoDTO> {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ContatoService contato_service;

	@Override
	public void initialize(ContatoAdicionar ann) {
	}

	@Override
	public boolean isValid(ContatoDTO contato, ConstraintValidatorContext context) {
		List<FieldMessage> lista = new ArrayList<>();

		// VALIDAÇÕES

		// Validação Telefone: DDD válido | cel = DDD + 9 | fixo = DDD + 8
		final String[] ddd = { "11", "12", "13", "14", "15", "16", "17", "18", "19", "21", "22", "24", "27", "28", "31",
				"32", "33", "34", "35", "37", "38", "41", "42", "43", "44", "45", "46", "47", "48", "49", "51", "53",
				"54", "55", "61", "62", "63", "64", "65", "66", "67", "68", "69", "71", "73", "74", "75", "77", "79",
				"81", "82", "83", "84", "85", "86", "87", "88", "89", "91", "92", "93", "94", "95", "96", "97", "98",
				"99" };

		String[] arrayTel = contato.getTelefone().split("");
		String dddTel = arrayTel[0] + arrayTel[1];
		Integer tam = arrayTel.length;
		boolean valido = false;

		for (int i = 0; i < ddd.length; i++) {
			if (dddTel.equals(ddd[i]) && (tam == 10 || tam == 11)) {
				valido = true;
				break;
			}
		}

		if (!valido) {
			lista.add(new FieldMessage("telefone", "Telfone inválido! Digite o DDD + telefone, somente números"));
		}

		// VALIDAÇÃO DE CAMPO ÚNICO:

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Long id = Long.parseLong(map.get("id"));
		
		// Validação e-mail:
		for (Contato i : contato_service.listar()) {
			if (i.getEmail().equals(contato.getEmail()) && !(i.getCliente().getId() ==  id))
				lista.add(new FieldMessage("email", "E-mail já registrado!"));
		}

		// CASO ALGUM TESTE RETORNE TRUE = RETORNA OS CAMPOS E ERROS
		for (FieldMessage e : lista) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMensagem_erro()).addPropertyNode(e.getNome_campo())
					.addConstraintViolation();
		}

		return lista.isEmpty();
	}

}
