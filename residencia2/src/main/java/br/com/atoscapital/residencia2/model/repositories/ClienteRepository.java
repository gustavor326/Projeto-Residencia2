package br.com.atoscapital.residencia2.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.atoscapital.residencia2.model.entities.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

	public Iterable<Cliente> findByNomeContainingIgnoreCase(String parteNome);

}
