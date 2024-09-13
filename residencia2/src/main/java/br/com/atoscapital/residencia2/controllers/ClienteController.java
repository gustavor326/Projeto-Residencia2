package br.com.atoscapital.residencia2.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.atoscapital.residencia2.model.entities.Cliente;
import br.com.atoscapital.residencia2.model.repositories.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping //Insere
	public @ResponseBody Cliente salvarCliente(@Valid Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}
	
	@GetMapping //Obtem todos
	public Iterable<Cliente> obterClientes() {
		return clienteRepository.findAll();
	}
	
	@GetMapping(path = "/nome/{parteNome}") //Obtem A PARTIR DE UM NOME e é ignorecase
	public Iterable<Cliente> obterClientesPorNome(@PathVariable String parteNome) {
		return clienteRepository.findByNomeContainingIgnoreCase(parteNome);
	}
	
	
	@GetMapping(path = "/{id}") //Obtem por ID
	public Optional<Cliente> obterClientePorId(@PathVariable Long id) {
		return clienteRepository.findById(id);
	}
	
	@PutMapping //altera parcialmente ou tdos os atributos
	public Cliente alterarCliente(@Valid Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}
	
	@DeleteMapping(path = "/{id}") // deleta o cliente
	public void excluirCliente(@PathVariable Long id) {
		clienteRepository.deleteById(id);
	}
	
}
