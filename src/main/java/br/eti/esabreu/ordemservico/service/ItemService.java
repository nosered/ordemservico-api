package br.eti.esabreu.ordemservico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.esabreu.ordemservico.model.Item;
import br.eti.esabreu.ordemservico.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	public Item save(Item item) {
		return itemRepository.save(item);
	}
	
	public Item find(Long id) {
		return itemRepository.findOne(id);
	}
	
	public List<Item> list() {
		return itemRepository.findAll();
	}
	
	public void remove(Long id) {
		itemRepository.delete(id);
	}
}