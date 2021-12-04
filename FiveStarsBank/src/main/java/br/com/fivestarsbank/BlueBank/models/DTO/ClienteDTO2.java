package br.com.fivestarsbank.BlueBank.models.DTO;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import br.com.fivestarsbank.BlueBank.service.validation.ClienteAtualizacao;

@ClienteAtualizacao
public class ClienteDTO2 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Length(min = 3, max = 50, message = "Nome entre 3 e 50 caracteres")
	private String nome;

	@Length(min = 2, max = 20, message = "Apelido entre 2 e 50 caracteres")
	private String apelido;

	@Length(min = 3, max = 15, message = "Gênero entre 3 e 15 caracteres")
	private String genero;

	public ClienteDTO2() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
