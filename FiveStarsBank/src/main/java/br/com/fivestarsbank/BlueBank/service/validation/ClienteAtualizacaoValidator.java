package br.com.fivestarsbank.BlueBank.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.fivestarsbank.BlueBank.controllers.exceptions.FieldMessage;
import br.com.fivestarsbank.BlueBank.models.DTO.ClienteDTO2;

public class ClienteAtualizacaoValidator implements ConstraintValidator<ClienteAtualizacao, ClienteDTO2> {
	
	@Override
	public void initialize(ClienteAtualizacao ann) {
	}

	@Override
	public boolean isValid(ClienteDTO2 cli, ConstraintValidatorContext context) {
		List<FieldMessage> lista = new ArrayList<>();

		//VALIDAÇÕES
         

        //CASO ALGUM TESTE RETORNE TRUE = RETORNA OS CAMPOS E ERROS
		for (FieldMessage e : lista) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMensagem_erro()).addPropertyNode(e.getNome_campo())
					.addConstraintViolation();
		}

		return lista.isEmpty();
	}
}
