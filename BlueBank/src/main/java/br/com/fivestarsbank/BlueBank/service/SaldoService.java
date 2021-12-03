package br.com.fivestarsbank.BlueBank.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fivestarsbank.BlueBank.models.Conta;
import br.com.fivestarsbank.BlueBank.models.Saldo;
import br.com.fivestarsbank.BlueBank.models.SaldoPK;
import br.com.fivestarsbank.BlueBank.repositories.SaldoRepository;
import br.com.fivestarsbank.BlueBank.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class SaldoService {

	@Autowired
	private SaldoRepository repo;

	public Saldo buscar(LocalDate data, Conta conta) {
		SaldoPK id = new SaldoPK();
		id.setData(data);
		id.setConta(conta);

		Optional<Saldo> saldo = repo.findById(id);
		return saldo.orElseThrow(() -> new ObjetoNaoEncontradoException("Saldo - Id Conta: " + id.getConta()));
	}

	public Saldo salvar(Saldo saldo) {
		return repo.save(saldo);
	}

}
