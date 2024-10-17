package br.com.atoscapital.residencia2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.atoscapital.residencia2.model.entities.Fatura;
import br.com.atoscapital.residencia2.model.repositories.FaturaRepository;
import br.com.atoscapital.residencia2.services.FaturaService;

@RestController
@RequestMapping("/api/fatura")
public class FaturaController {
	@Autowired
	private FaturaRepository faturaRepository;

	@Autowired
	private FaturaService faturaService;

	@PostMapping
	public Fatura salvarFatura(Fatura fatura) {
		return faturaRepository.save(fatura);
	}

	@PutMapping("/{id}")
	public Fatura atualizarFatura(@PathVariable Long id, @RequestBody Fatura fatura) {
		return faturaService.atualizarFatura(id, fatura);
	}

	@GetMapping
	public List<Fatura> buscarFaturas() {
		return (List<Fatura>) faturaRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Fatura> buscarFaturaPorId(@PathVariable Long id) {
		return faturaRepository.findById(id);
	}

	@GetMapping("/id/{clienteId}")
	public List<Fatura> buscarFaturasPorClienteId(@PathVariable Long clienteId) {
		return faturaRepository.findByClienteId(clienteId);
	}

	@GetMapping("/cpf/{cpf}")
	public List<Fatura> buscarFaturasPorClienteCpf(@PathVariable String cpf) {
		return faturaRepository.findByClienteCpf(cpf);
	}

	@DeleteMapping("/logica/{id}")
	public void deletarFaturaLogica(@PathVariable Long id) {
		faturaService.excluirFaturaLogica(id);
	}

	@DeleteMapping("/fisica/{id}")
	public void deletarFatura(@PathVariable Long id) {
		faturaService.excluirFaturaFisica(id);
	}
}
