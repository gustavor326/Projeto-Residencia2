package br.com.atoscapital.residencia2.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class Pagamento {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message = "O valor do pagamento não pode ser vazio")
    @PositiveOrZero(message = "O valor do pagamento não pode ser negativo")
    private Float valor;
	

    @NotBlank(message = "A data do pagamento não pode ser vazia")
    private String dataPagamento;

    @ManyToOne
    @JoinColumn(name = "fatura_id", nullable = false)
    private Fatura fatura;
    
	public Pagamento() {
		
	}
    
    public Pagamento(Float valor, String dataPagamento, Fatura fatura) {
		super();
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.fatura = fatura;
	}
    
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }
}
