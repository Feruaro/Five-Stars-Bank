package br.com.fivestarsbank.BlueBank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fivestarsbank.BlueBank.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
