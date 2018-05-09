package br.com.hotel.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_servico")
@NamedQueries({
	@NamedQuery(name="Servico.listing", query = "SELECT servico FROM Servico servico"),
	@NamedQuery(name="Servico.findByCode", query = "SELECT servico FROM Servico servico WHERE servico.id = :code")
})
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ser_codigo")
	private Long id;

	@Column(name = "ser_nome", length = 45, nullable = false)
	private String nome;

	@Column(name = "ser_descricao", length = 100)
	private String descricao;

	@Column(name = "ser_preco", precision = 7, scale = 2, nullable = false)
	private BigDecimal preco;

	public Servico(){
		
	}
	
	public Servico(String nome, String descricao, BigDecimal preco) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Servico [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + "]";
	}
	
	

}
