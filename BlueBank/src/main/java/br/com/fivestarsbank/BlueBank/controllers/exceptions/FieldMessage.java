package br.com.fivestarsbank.BlueBank.controllers.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome_campo;
	private String mensagem_erro;

	public FieldMessage(String nome_campo, String mensagem_erro) {
		this.nome_campo = nome_campo;
		this.mensagem_erro = mensagem_erro;
	}

	public String getNome_campo() {
		return nome_campo;
	}

	public void setNome_campo(String nome_campo) {
		this.nome_campo = nome_campo;
	}

	public String getMensagem_erro() {
		return mensagem_erro;
	}

	public void setMensagem_erro(String mensagem_erro) {
		this.mensagem_erro = mensagem_erro;
	}

}
