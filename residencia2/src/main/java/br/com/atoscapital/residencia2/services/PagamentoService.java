package br.com.atoscapital.residencia2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atoscapital.residencia2.model.entities.Pagamento; 
import br.com.atoscapital.residencia2.model.repositories.PagamentoRepository; 

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento atualizarPagamento(Long id, Pagamento pagamento) {
        if (!pagamentoRepository.existsById(id)) {
            throw new RuntimeException("Pagamento não encontrado com ID: " + id);
        }
        pagamento.setId(id);
        return pagamentoRepository.save(pagamento);
    }
}
