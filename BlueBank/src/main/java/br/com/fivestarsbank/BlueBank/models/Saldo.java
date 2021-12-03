package br.com.fivestarsbank.BlueBank.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Saldo implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SaldoPK id = new SaldoPK();

	@NotNull
	private Double saldo;

	public Saldo() {
	}

	public Saldo(LocalDate data, Conta conta, Double saldo) {
		this.id.setData(data);
		this.id.setConta(conta);
		this.saldo = saldo;
	}

	public LocalDate getData() {
		return id.getData();
	}

	public Conta getConta() {
		return id.getConta();
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
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
		Saldo other = (Saldo) obj;
		return Objects.equals(id, other.id);
	}

}
