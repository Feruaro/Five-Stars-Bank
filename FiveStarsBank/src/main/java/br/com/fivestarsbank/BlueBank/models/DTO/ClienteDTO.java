package br.com.fivestarsbank.BlueBank.models.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fivestarsbank.BlueBank.service.validation.ClienteCadastro;
import io.swagger.annotations.ApiModelProperty;

//DTO Cliente para cadastro
@ClienteCadastro
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 8, max = 20, message = "Senha entre 8 e 20 caracteres")
	private String senha;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 3, max = 50, message = "Nome entre 3 e 50 caracteres")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 2, max = 20, message = "Apelido entre 2 e 50 caracteres")
	private String apelido;

	@ApiModelProperty(value = "Tipo de cliente - código (1 ou 2)")
	@NotNull(message = "Preenchimento obrigatório")
	private Integer tipo;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 11, max = 14, message = "CPF = 11, CNPJ = 14, apenas números")
	private String cpf_cnpj;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 3, max = 14, message = "RG = 10, IE = 14, apenas números")
	private String rg_ie;

	@Length(min = 3, max = 15, message = "Gênero entre 3 e 15 caracteres")
	private String genero;

	private String data_nascimento;

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

	public ClienteDTO() {
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getRg_ie() {
		return rg_ie;
	}

	public void setRg_ie(String rg_ie) {
		this.rg_ie = rg_ie;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
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
