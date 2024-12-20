package br.com.atoscapital.residencia2.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.atoscapital.residencia2.model.entities.Cliente;
import br.com.atoscapital.residencia2.model.repositories.ClienteRepository;
import br.com.atoscapital.residencia2.services.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public @ResponseBody Cliente salvarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}

	@PutMapping("/{id}")
	public Cliente atualizarCliente(@PathVariable Long id, Cliente cliente) {
		return clienteService.atualizarCliente(id, cliente);
	}

	@GetMapping
	public Iterable<Cliente> obterClientes() {
		return clienteRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Cliente> obterClientePorId(@PathVariable Long id) {
		return clienteRepository.findById(id);
	}

	@GetMapping(path = "/nome/{parteNome}")
	public Iterable<Cliente> obterClientesPorNome(@PathVariable String parteNome) {
		return clienteRepository.findByNomeContainingIgnoreCase(parteNome);
	}

	@GetMapping(path = "/cpf/{cpf}")
	public Iterable<Cliente> obterClientePorCpf(@PathVariable String cpf) {
		return clienteRepository.findByCpf(cpf);
	}

	@DeleteMapping(path = "/fisica/{id}")
	public void deletarClienteFisico(@PathVariable Long id) {
		clienteRepository.deleteById(id);
	}

}
