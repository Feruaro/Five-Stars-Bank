package br.com.fivestarsbank.BlueBank.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;

	private List<FieldMessage> erros = new ArrayList<>();
	
	public ValidationError(Integer statusHttp, String mensagemErro, Long timeStamp) {
		super(statusHttp, mensagemErro, timeStamp);
	}

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addError(String nome, String mensagem) {
		erros.add(new FieldMessage(nome, mensagem));
	}

}
