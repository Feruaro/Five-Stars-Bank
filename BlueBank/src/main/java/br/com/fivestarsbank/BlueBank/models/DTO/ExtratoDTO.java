package br.com.fivestarsbank.BlueBank.models.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.fivestarsbank.BlueBank.models.Conta;
import br.com.fivestarsbank.BlueBank.models.Movimentacao;

public class ExtratoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Conta conta;
	
	private Integer periodo;
	
	private Double saldo_inicial;
	
	private List<Movimentacao> listaMovi = new ArrayList<>();
	
	private Double saldo_final;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getPeriodo() {
		String p = Integer.toString(periodo) + " dias";
		return p;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public Double getSaldo_inicial() {
		return saldo_inicial;
	}

	public void setSaldo_inicial(Double saldo_inicial) {
		this.saldo_inicial = saldo_inicial;
	}

	public List<Movimentacao> getListaMovi() {
		return listaMovi;
	}

	public void setListaMovi(List<Movimentacao> listaMovi) {
		this.listaMovi = listaMovi;
	}

	public Double getSaldo_final() {
		return saldo_final;
	}

	public void setSaldo_final(Double saldo_final) {
		this.saldo_final = saldo_final;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

}
