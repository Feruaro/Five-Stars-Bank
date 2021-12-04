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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fivestarsbank.BlueBank.models.enums.StatusConta;

@Entity
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(unique = true)
	private Integer numero_conta;

	@NotNull
	private Integer digito_conta;

	@NotNull
	private Integer agencia;

	@NotNull
	private Integer codigo_banco;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_abertura;	

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_fechamento;
	
	@NotNull
	private Integer status;

	@JsonIgnore
	@ManyToOne
	private Cliente cliente;

	@JsonIgnore
	@OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
	private List<Movimentacao> transacoes = new ArrayList<>();

	public Conta() {
	}

	public Conta(Integer digito_conta, Integer agencia, Integer codigo_banco, StatusConta status, Integer numero_conta,
			Cliente cliente) {
		this.digito_conta = digito_conta;
		this.agencia = agencia;
		this.codigo_banco = codigo_banco;
		this.status = status.getCod();
		this.numero_conta = numero_conta;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero_conta() {
		return numero_conta;
	}

	public void setNumero_conta(Integer numero_conta) {
		this.numero_conta = numero_conta;
	}

	public Integer getDigito_conta() {
		return digito_conta;
	}

	public void setDigito_conta(Integer digito_conta) {
		this.digito_conta = digito_conta;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getCodigo_banco() {
		return codigo_banco;
	}

	public void setCodigo_banco(Integer codigo_banco) {
		this.codigo_banco = codigo_banco;
	}

	public LocalDate getData_abertura() {
		return data_abertura;
	}

	public void setData_abertura(LocalDate data_abertura) {
		this.data_abertura = data_abertura;
	}

	public LocalDate getData_fechamento() {
		return data_fechamento;
	}

	public void setData_fechamento(LocalDate data_fechamento) {
		this.data_fechamento = data_fechamento;
	}

	public StatusConta getStatus() {
		return StatusConta.toEnum(status);
	}

	public void setStatus(StatusConta status) {
		this.status = status.getCod();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Movimentacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Movimentacao> transacoes) {
		this.transacoes = transacoes;
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
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id);
	}

}
