package br.com.hotel.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_cliente")
@NamedQueries({
	@NamedQuery(name="Cliente.listing", query = "SELECT cliente FROM Cliente cliente"),
	@NamedQuery(name="Cliente.findByCode", query = "SELECT cliente FROM Cliente cliente WHERE cliente.id = :code")
})
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cli_codigo")
	private Long id;

	@Column(name = "cli_nome", length = 50, nullable = false)
	private String nome;

	@Column(name = "cli_cpf", length = 14, nullable = false, unique = true)
	private String cpf;

	@Column(name = "cli_profissao", length = 50)
	private String profissao;

	public Cliente() {
		
	}

	public Cliente(String nome, String cpf, String profissao) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.profissao = profissao;
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

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", profissao=" + profissao + "]";
	}
	
	

}
