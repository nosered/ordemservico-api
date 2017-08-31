package br.eti.esabreu.ordemservico.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> get(@PathVariable("id") Long id) {
		Item item = itemService.find(id);
		return ResponseEntity.ok().body(item);
	}
	
	@GetMapping
	public ResponseEntity<List<Item>> list() {
		List<Item> itens = itemService.list();
		return ResponseEntity.ok().body(itens);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Item> update(@RequestBody Item item, @PathVariable("id") Long id) {
		item.setId(id);
		Item itemSalvo = itemService.save(item);
		return ResponseEntity.ok().body(itemSalvo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable("id") Long id) {
		itemService.remove(id);
		return ResponseEntity.ok().build();
	}
}