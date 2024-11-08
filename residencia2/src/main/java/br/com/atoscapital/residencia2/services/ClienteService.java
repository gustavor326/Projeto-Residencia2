package br.com.atoscapital.residencia2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atoscapital.residencia2.model.entities.Cliente;
import br.com.atoscapital.residencia2.model.repositories.ClienteRepository;

@Service
public class ClienteService {

	    @Autowired
	    private ClienteRepository clienteRepository;

	    public Cliente atualizarCliente(Long id, Cliente cliente) {
	        if (!clienteRepository.existsById(id)) {
	            throw new RuntimeException("Cliente não encontrado com ID: " + id);
	        }
	        cliente.setId(id);
	        return clienteRepository.save(cliente);
	    }
	}


