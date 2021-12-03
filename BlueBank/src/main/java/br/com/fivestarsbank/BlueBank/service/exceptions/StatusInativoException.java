package br.com.fivestarsbank.BlueBank.service.exceptions;

public class StatusInativoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StatusInativoException(String tipo, Long id) {
		super(tipo + " já está inativo! Id: " + id);
	}
	
	public StatusInativoException(String tipo) {
		super("Impossível inativar " + tipo + "! Motivo: Lista de " + tipo + " não pode ser nula!");
	}	

	public StatusInativoException(String message, Throwable cause) {
		super(message, cause);
	}

	
	
	
}
