package br.eti.esabreu.ordemservico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.esabreu.ordemservico.model.Cliente;
import br.eti.esabreu.ordemservico.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente find(Long id) {
		return clienteRepository.findOne(id);
	}
	
	public List<Cliente> list() {
		return clienteRepository.findAll();
	}
	
	public void remove(Long id) {
		clienteRepository.delete(id);
	}

}
