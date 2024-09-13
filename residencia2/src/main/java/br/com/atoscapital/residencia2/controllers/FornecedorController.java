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

import br.com.atoscapital.residencia2.model.entities.Fornecedor;
import br.com.atoscapital.residencia2.model.repositories.FornecedorRepository;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@PostMapping //Insere
	public @ResponseBody Fornecedor salvarFornecedor(@Valid Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
		return fornecedor;
	}
	
	@GetMapping //Obtem todos
	public Iterable<Fornecedor> obterFornecedor() {
		return fornecedorRepository.findAll();
	}
	
	@GetMapping(path = "/nome/{parteNome}") //Obtem A PARTIR DE UM NOME e é ignorecase
	public Iterable<Fornecedor> obterFornecedorPorNome(@PathVariable String parteNome) {
		return fornecedorRepository.findByNomeContainingIgnoreCase(parteNome);
	}
	
	@GetMapping(path = "/{id}") //Obtem por ID
	public Optional<Fornecedor> obterFornecedorPorId(@PathVariable Long id) {
		return fornecedorRepository.findById(id);
	}
	
	@PutMapping //altera parcialmente ou tdos os atributos
	public Fornecedor alterarFornecedor(@Valid Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
		return fornecedor;
	}
	@DeleteMapping(path = "/{id}") // deleta o fornecedor
	public void excluirFornecedor(@PathVariable Long id) {
		fornecedorRepository.deleteById(id);
	}
}
