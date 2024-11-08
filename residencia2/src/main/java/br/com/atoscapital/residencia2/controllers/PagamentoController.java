package br.com.atoscapital.residencia2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.atoscapital.residencia2.model.entities.Fatura;
import br.com.atoscapital.residencia2.model.entities.Pagamento;
import br.com.atoscapital.residencia2.model.repositories.FaturaRepository;
import br.com.atoscapital.residencia2.model.repositories.PagamentoRepository;
import br.com.atoscapital.residencia2.services.PagamentoService; 

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private FaturaRepository faturaRepository;
    @Autowired
    private PagamentoService pagamentoService;
    
    @PostMapping
    public Pagamento salvarPagamento(Pagamento pagamento) {
        Pagamento novoPagamento = pagamentoRepository.save(pagamento);
        
        Fatura fatura = novoPagamento.getFatura();
        fatura.adicionarPagamento(novoPagamento.getValor());
        faturaRepository.save(fatura); 

        return novoPagamento;
    }

    @PutMapping("/{id}")
    public Pagamento atualizarPagamento(@PathVariable Long id, @RequestBody Pagamento pagamento) {
        return pagamentoService.atualizarPagamento(id, pagamento);
    }

    @GetMapping
    public List<Pagamento> buscarPagamentos() {
        return (List<Pagamento>) pagamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pagamento> buscarPagamentoPorId(@PathVariable Long id) {
        return pagamentoRepository.findById(id);
    }

    @GetMapping("/cpf/{cpf}")
    public List<Pagamento> buscarPagamentosPorCpf(@PathVariable String cpf) {
        return pagamentoRepository.findByFatura_Cliente_Cpf(cpf);
    }
    
}
