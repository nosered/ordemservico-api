package br.eti.esabreu.ordemservico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.eti.esabreu.ordemservico.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}