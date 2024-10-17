package br.com.atoscapital.residencia2.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente", uniqueConstraints = @UniqueConstraint(columnNames = "cpf"))
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome não pode ser nulo")
	private String nome;
	
	@Column(nullable = false, unique = true)
	@Size(min = 11, max = 11, message = "O cpf deve ter 11 caracteres")
	private String cpf;
	
	@Column(columnDefinition = "TEXT")
	private String endereco;
	
	@NotBlank(message = "O número não pode ser nulo")
    private String telefone;
    
    @NotBlank(message = "A data de nascimento não pode ser nula")
    private String DataDeNascimento;
    
    @Email(message = "Email deve ser válido")
    private String email;

	public Cliente() {

	}

	public Cliente(String nome, String cpf, String telefone, String endereco, String DataDeNascimento, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.DataDeNascimento = DataDeNascimento;
		this.email = email;
		} 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDataDeNascimento() {
		return DataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		DataDeNascimento = dataDeNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
