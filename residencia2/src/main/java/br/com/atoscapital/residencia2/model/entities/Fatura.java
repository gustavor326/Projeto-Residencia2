package br.com.atoscapital.residencia2.model.entities;

import javax.persistence.Entity;
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

	@NotBlank(message = "dataEmissao não pode ser nulo")
	private String dataEmissao;

	@NotBlank(message = "dataVencimento não pode ser nulo")
	private String dataVencimento;

	private boolean faturaAtiva = true;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	public Fatura() {

	}

	public Fatura(String descricao, Float valor, String dataEmissao, String dataVencimento, Cliente cliente) {
		this.descricao = descricao;
		this.valor = valor;
		this.dataEmissao = dataEmissao;
		this.dataVencimento = dataVencimento;
		this.cliente = cliente;
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

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getdataVencimento() {
		return dataVencimento;
	}

	public void setdataVencimento(String dataVencimento) {
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

}
