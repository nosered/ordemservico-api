package br.eti.esabreu.ordemservico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.eti.esabreu.ordemservico.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
