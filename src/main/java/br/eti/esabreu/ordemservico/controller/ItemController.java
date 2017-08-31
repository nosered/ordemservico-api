package br.eti.esabreu.ordemservico.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.eti.esabreu.ordemservico.model.Item;
import br.eti.esabreu.ordemservico.service.ItemService;

@RestController
@RequestMapping("/itens")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@PostMapping
	public ResponseEntity<Item> add(@RequestBody Item item) {
		Item itemSalvo = itemService.save(item);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequestUri()
				.path("/{id}")
				.buildAndExpand(itemSalvo.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(itemSalvo);
	}
}