package br.com.atoscapital.residencia2.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atoscapital.residencia2.model.entities.Fatura;
import br.com.atoscapital.residencia2.model.entities.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
	public List<Pagamento> findByFaturaId(Long faturaId);
	List<Pagamento> findByFatura_Cliente_Cpf(String cpf); 
}
