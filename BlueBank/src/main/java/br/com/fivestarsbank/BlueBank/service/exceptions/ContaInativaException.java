package br.com.fivestarsbank.BlueBank.service.exceptions;

public class ContaInativaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ContaInativaException() {
		super("Impossível excluir cliente! Motivo: Cliente possui conta(s) ativa(s)!");
	}
	
	public ContaInativaException(Long id) {
		super("Impossível fazer uma movimentação! Motivo: Conta inativa! Id conta: " + id);
	}

	public ContaInativaException(String message, Throwable cause) {
		super(message, cause);
	}

	
	
	
}
