package br.com.fivestarsbank.BlueBank.service.exceptions;

public class ObjetoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjetoNaoEncontradoException(String message) {
		super("Não foi possível encontrar: " + message);
	}

	public ObjetoNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	
	
	
}
