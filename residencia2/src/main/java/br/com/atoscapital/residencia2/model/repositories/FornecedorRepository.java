package br.com.atoscapital.residencia2.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.atoscapital.residencia2.model.entities.Fornecedor;

public interface FornecedorRepository extends PagingAndSortingRepository<Fornecedor, Long>{
	
	public Iterable<Fornecedor> findByNomeContainingIgnoreCase(String parteNome);

}
