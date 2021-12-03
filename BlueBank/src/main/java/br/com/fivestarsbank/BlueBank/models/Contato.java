package br.com.fivestarsbank.BlueBank.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fivestarsbank.BlueBank.models.enums.StatusEnderecoContato;

@Entity
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Length(max = 11)
	private String telefone;

	@NotNull
	@Length(max = 10)
	private String descricao;

	@Length(max = 25)
	private String contato_tel;

	@NotNull
	@Length(max = 50)
	private String email;

	private Integer statusContato;

	@JsonIgnore
	@ManyToOne
	private Cliente cliente;

	public Contato() {
	}

	public Contato(String telefone, String contato_tel, String descricao, String email, StatusEnderecoContato status) {
		this.telefone = telefone;
		this.contato_tel = contato_tel;
		this.descricao = descricao;
		this.email = email;
		this.statusContato = status.getCod();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public StatusEnderecoContato getStatusContato() {
		return StatusEnderecoContato.toEnum(statusContato);
	}

	public void setStatusContato(StatusEnderecoContato statusContato) {
		this.statusContato = statusContato.getCod();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(id, other.id);
	}

}
