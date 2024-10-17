package br.com.atoscapital.residencia2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atoscapital.residencia2.model.entities.Fatura;
import br.com.atoscapital.residencia2.model.repositories.FaturaRepository;

@Service
public class FaturaService {
	 @Autowired
	    private FaturaRepository faturaRepository;

	    public void excluirFaturaLogica(Long id) {
	        Fatura fatura = faturaRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Fatura não encontrada com ID: " + id));
	        fatura.setFaturaAtiva(false);
	        faturaRepository.save(fatura);
	    }
	    
	    public void excluirFaturaFisica(Long id) {
	        if (!faturaRepository.existsById(id)) {
	            throw new RuntimeException("Fatura não encontrada com ID: " + id);
	        }
	        faturaRepository.deleteById(id);
	    }
	    public Fatura atualizarFatura(Long id, Fatura fatura) {
	        if (!faturaRepository.existsById(id)) {
	            throw new RuntimeException("Fatura não encontrada com ID: " + id);
	        }
	        fatura.setId(id);
	        return faturaRepository.save(fatura);
	    }
}
