package br.com.fivestarsbank.BlueBank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fivestarsbank.BlueBank.models.Saldo;
import br.com.fivestarsbank.BlueBank.models.SaldoPK;

@Repository
public interface SaldoRepository extends JpaRepository<Saldo, SaldoPK> {
	
}
