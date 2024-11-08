package br.com.atoscapital.residencia2.model.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "fatura")
public class Fatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "A descrição não pode ser nula")
	private String descricao;

	@NotNull(message = "O valor da fatura não pode ser nulo")
    @Min(value = (long) 0.01f, message = "O valor da fatura deve ser positivo (mínimo 0.01)")
	private Float valor;

	@Column(name = "data_emissao", nullable = false)
	private LocalDate dataEmissao;

	@Column(name = "data_vencimento", nullable = false)
	private LocalDate dataVencimento;

	private boolean faturaAtiva = true;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	 
	private Float valorTotalPagamentos = 0f;
	
    @Enumerated(EnumType.STRING)
    private StatusFatura status = StatusFatura.PENDENTE;

    public void adicionarPagamento(Float valorPagamento) {
    	if (valorTotalPagamentos == null) {
            valorTotalPagamentos = 0f;
        }
    	
    	if (valorTotalPagamentos + valorPagamento > valor) {
            valorTotalPagamentos = valor;
        } else {
            this.valorTotalPagamentos += valorPagamento;
        }
        
        atualizarStatus();
    }

    private void atualizarStatus() {
        this.status = valorTotalPagamentos >= valor ? StatusFatura.PAGO : StatusFatura.PENDENTE;
    }
	
	public Fatura() {
		this.dataEmissao = LocalDate.now();
		this.dataVencimento = this.dataEmissao.plusDays(15);
	}

	public Fatura(String descricao, Float valor, Cliente cliente) {
		this.descricao = descricao;
		this.valor = valor;
		this.dataEmissao = LocalDate.now();
		this.dataVencimento = this.dataEmissao.plusDays(15);
		this.cliente = cliente;
		this.valorTotalPagamentos = 0f;
	    this.status = StatusFatura.PENDENTE; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isFaturaAtiva() {
		return faturaAtiva;
	}

	public void setFaturaAtiva(boolean faturaAtiva) {
		this.faturaAtiva = faturaAtiva;
	}

	public Float getValorTotalPagamentos() {
		return valorTotalPagamentos;
	}

	public void setValorTotalPagamentos(Float valorTotalPagamentos) {
		this.valorTotalPagamentos = valorTotalPagamentos;
	}

	public StatusFatura getStatus() {
		return status;
	}

	public void setStatus(StatusFatura status) {
		this.status = status;
	}
	
	
}
