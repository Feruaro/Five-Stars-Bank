package br.com.fivestarsbank.BlueBank.models.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fivestarsbank.BlueBank.service.validation.MovimentacaoIncluir;

@MovimentacaoIncluir
public class MovimentacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Preenchimento obrigatório")
	private Long id_transacao;

	@NotNull(message = "Preenchimento obrigatório")
	private Integer tipo;

	@NotNull(message = "Preenchimento obrigatório")
	private Double valor;

	@NotNull(message = "Preenchimento obrigatório, 1 = Crédito, 2 = Débito")
	private Integer credito_debito;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(max = 20, message = "Descrição com no máximo 20 caracteres")
	private String descricao;

	public MovimentacaoDTO() {
	}

	public Long getId_transacao() {
		return id_transacao;
	}

	public void setId_transacao(Long id_transacao) {
		this.id_transacao = id_transacao;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getCredito_debito() {
		return credito_debito;
	}

	public void setCredito_debito(Integer credito_debito) {
		this.credito_debito = credito_debito;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
