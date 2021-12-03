package br.com.fivestarsbank.BlueBank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fivestarsbank.BlueBank.models.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
