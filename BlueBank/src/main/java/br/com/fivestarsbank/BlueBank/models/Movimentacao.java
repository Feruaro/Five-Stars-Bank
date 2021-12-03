package br.com.fivestarsbank.BlueBank.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fivestarsbank.BlueBank.models.enums.DebitoCredito;
import br.com.fivestarsbank.BlueBank.models.enums.TipoTransacao;

@Entity
public class Movimentacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Long id_transacao;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_transacao;

	@NotNull
	private Integer tipo;

	@NotNull
	private Double valor;

	@NotNull
	private Integer credito_debito;

	@NotNull
	@Length(max = 20)
	private String descricao;

	@JsonIgnore
	@ManyToOne
	private Conta conta;

	public Movimentacao() {
	}

	public Movimentacao(Long id_transacao, TipoTransacao tipo, Double valor, DebitoCredito credito_debito, String descricao) {
		this.id_transacao = id_transacao;
		this.setTipo(tipo);
		this.valor = valor;
		this.setCredito_debito(credito_debito);
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_transacao() {
		return id_transacao;
	}

	public void setId_transacao(Long id_transacao) {
		this.id_transacao = id_transacao;
	}

	public TipoTransacao getTipo() {
		return TipoTransacao.toEnum(tipo);
	}

	public void setTipo(TipoTransacao tipo) {
		this.tipo = tipo.getCod();
	}

	public LocalDate getData_transacao() {
		return data_transacao;
	}

	public void setData_transacao(LocalDate data_transacao) {
		this.data_transacao = data_transacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public DebitoCredito getCredito_debito() {
		return DebitoCredito.toEnum(credito_debito);
	}

	public void setCredito_debito(DebitoCredito credito_debito) {
		this.credito_debito = credito_debito.getCod();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
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
		Movimentacao other = (Movimentacao) obj;
		return Objects.equals(id, other.id);
	}

}
