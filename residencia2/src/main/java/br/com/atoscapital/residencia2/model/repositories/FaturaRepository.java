package br.com.atoscapital.residencia2.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.atoscapital.residencia2.model.entities.Fatura;

public interface FaturaRepository extends CrudRepository<Fatura, Long>{
	public List<Fatura> findByClienteId(Long clienteId);
	public List<Fatura> findByClienteCpf(String cpf);
	
}
