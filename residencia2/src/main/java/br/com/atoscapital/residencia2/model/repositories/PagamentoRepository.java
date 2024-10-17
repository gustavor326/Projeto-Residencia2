package br.com.atoscapital.residencia2.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atoscapital.residencia2.model.entities.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

}
