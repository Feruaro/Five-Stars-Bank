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
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Length(max = 120)
	private String logradouro;

	@Length(max = 50)
	private String complemento;

	@NotNull
	@Length(max = 30)
	private String bairro;

	@NotNull
	@Length(max = 8)
	private String cep;

	@NotNull
	@Length(max = 50)
	private String cidade;

	@NotNull
	@Length(max = 2)
	private String estado;

	@NotNull
	@Length(max = 30)
	private String pais;

	private Integer statusEnd;

	@JsonIgnore
	@ManyToOne
	private Cliente cliente;

	public Endereco() {
	}

	public Endereco(String logradouro, String complemento, String bairro, String cep, String cidade, String estado,
			String pais, StatusEnderecoContato status) {
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.statusEnd = status.getCod();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public StatusEnderecoContato getStatusEnd() {
		return StatusEnderecoContato.toEnum(statusEnd);
	}

	public void setStatusEnd(StatusEnderecoContato statusEnd) {
		this.statusEnd = statusEnd.getCod();
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
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}

}
