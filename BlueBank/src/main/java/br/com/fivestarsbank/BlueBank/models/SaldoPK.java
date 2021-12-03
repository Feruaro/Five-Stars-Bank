package br.com.fivestarsbank.BlueBank.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Embeddable
public class SaldoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;

	@ManyToOne
	private Conta conta;

	public SaldoPK() {
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conta, data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaldoPK other = (SaldoPK) obj;
		return Objects.equals(conta, other.conta) && Objects.equals(data, other.data);
	}

}
