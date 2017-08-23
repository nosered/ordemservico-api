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

import br.eti.esabreu.ordemservico.model.Cliente;
import br.eti.esabreu.ordemservico.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Cliente> add(@RequestBody Cliente cliente) {
		Cliente clienteSalvo = clienteService.save(cliente);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequestUri()
				.path("/{id}").
				buildAndExpand(clienteSalvo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(clienteSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> find(@PathVariable("id") Long id) {
		Cliente clienteSalvo = clienteService.find(id);
		return ResponseEntity.ok().body(clienteSalvo);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> list() {
		List<Cliente> clientes = clienteService.list();
		return ResponseEntity.ok().body(clientes);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		cliente.setId(id);
		Cliente clienteSalvo = clienteService.save(cliente);
		return ResponseEntity.ok().body(clienteSalvo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable("id") Long id) {
		clienteService.remove(id);
		return ResponseEntity.noContent().build();
	}
}
