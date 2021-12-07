package br.com.fivestarsbank.BlueBank.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fivestarsbank.BlueBank.models.enums.TipoCliente;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@NotNull
	@Length(max = 20)
	private String senha;

	@NotNull
	@Length(max = 50)
	private String nome;

	@NotNull
	@Length(max = 20)
	private String apelido;

	@NotNull
	private Integer tipo;

	@NotNull
	@Column(unique = true)
	@Length(max = 14)
	private String cpf_cnpj;

	@NotNull
	@Column(unique = true)
	@Length(max = 14)
	private String rg_ie;

	@Length(max = 15)
	private String genero;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_nascimento;

	@ApiModelProperty(value = "ARN do topic - SNS AWS")
	private String topico;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Contato> contatos = new ArrayList<>();

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Conta> contas = new ArrayList<>();

	public Cliente() {
	}

	public Cliente(String nome, String apelido, TipoCliente tipo, String cpf_cnpj, String rg_ie, String genero,
			LocalDate data_nascimento) {
		this.nome = nome;
		this.apelido = apelido;
		this.tipo = tipo.getCod();
		this.cpf_cnpj = cpf_cnpj;
		this.rg_ie = rg_ie;
		this.genero = genero;
		this.data_nascimento = data_nascimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
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

	public LocalDate getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getTopico() {
		return topico;
	}

	public void setTopico(String topico) {
		this.topico = topico;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

}
