package br.com.fivestarsbank.BlueBank.models.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.fivestarsbank.BlueBank.service.validation.EnderecoAdicionar;

@EnderecoAdicionar
public class EnderecoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 3, max = 120, message = "Logradouro entre 3 e 120 caracteres")
	private String logradouro;

	@Length(max = 50, message = "Complemento com no máximo 50 caracteres")
	private String complemento;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 3, max = 30, message = "Bairro entre 3 e 30 caracteres")
	private String bairro;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 8, max = 8, message = "CEP com 8 caracteres, apenas números")
	private String cep;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 3, max = 50, message = "Cidade entre 3 e 50 caracteres")
	private String cidade;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 2, max = 2, message = "Estado com 2 caracteres, apenas a sigla")
	private String estado;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 3, max = 30, message = "País entre 3 e 30 caracteres")
	private String pais;

	public EnderecoDTO() {
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
	
	
}
