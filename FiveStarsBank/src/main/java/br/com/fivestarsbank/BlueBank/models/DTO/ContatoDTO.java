package br.com.fivestarsbank.BlueBank.models.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.fivestarsbank.BlueBank.service.validation.ContatoAdicionar;

@ContatoAdicionar
public class ContatoDTO {

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 10, max = 11, message = "Telefone: cel = 11 e fixo = 10, DDD + número telefone, apenas números")
	private String telefone;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 3, max = 10, message = "Descrição entre 3 e 10 caracteres.")
	private String descricao;

	@Length(min = 3, max = 25, message = "Contato de referência entre 3 e 25 caracteres.")
	private String contato_tel;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 10, max = 50, message = "E-mail entre 10 e 50 caracteres.")
	@Email
	private String email;

	public ContatoDTO() {
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getContato_tel() {
		return contato_tel;
	}

	public void setContato_tel(String contato_tel) {
		this.contato_tel = contato_tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
