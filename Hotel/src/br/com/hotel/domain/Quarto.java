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
@Table(name = "tbl_quarto")
@NamedQueries({
	@NamedQuery(name="Quarto.listing", query = "SELECT quarto FROM Quarto quarto"),
	@NamedQuery(name="Quarto.findByCode", query = "SELECT quarto FROM Quarto quarto WHERE quarto.id = :code")
})
public class Quarto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "qua_codigo")
	private Long id;

	@Column(name = "qua_numero", length = 5, nullable = false)
	private String numero;

	@Column(name = "qua_num_pessoas", nullable = false)
	private int num_pessoas;

	@Column(name = "qua_ar_condicionado", nullable = false)
	private boolean ar_condicionado;

	@Column(name = "qua_tv", nullable = false)
	private boolean tv;

	@Column(name = "qua_reservado", nullable = false)
	private boolean reservado;

	@Column(name = "qua_alugado", nullable = false)
	private boolean alugado;

	@Column(name = "qua_descricao", length = 100)
	private String descricao;

	@Column(name = "qua_tamanho", nullable = false)
	private int tamanho;

	@Column(name = "qua_preco", precision = 7, scale = 2, nullable = false)
	private BigDecimal preco;
	
	public Quarto(){
		
	}

	public Quarto(String numero, int num_pessoas, boolean ar_condicionado, boolean tv, String descricao, int tamanho, BigDecimal preco) {
		super();
		this.numero = numero;
		this.num_pessoas = num_pessoas;
		this.ar_condicionado = ar_condicionado;
		this.tv = tv;
		this.reservado = false;
		this.alugado = false;
		this.descricao = descricao;
		this.tamanho = tamanho;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getNum_pessoas() {
		return num_pessoas;
	}

	public void setNum_pessoas(int num_pessoas) {
		this.num_pessoas = num_pessoas;
	}

	public boolean isAr_condicionado() {
		return ar_condicionado;
	}

	public void setAr_condicionado(boolean ar_condicionado) {
		this.ar_condicionado = ar_condicionado;
	}

	public Boolean getTv() {
		return tv;
	}

	public void setTv(Boolean tv) {
		this.tv = tv;
	}

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Quarto [id=" + id + ", numero=" + numero + ", num_pessoas=" + num_pessoas + ", ar_condicionado="
				+ ar_condicionado + ", tv=" + tv + ", reservado=" + reservado + ", alugado=" + alugado + ", descricao="
				+ descricao + ", tamanho=" + tamanho + ", preco=" + preco + "]";
	}

	
}
