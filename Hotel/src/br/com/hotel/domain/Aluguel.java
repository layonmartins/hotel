package br.com.hotel.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_aluguel")
@NamedQueries({
	@NamedQuery(name="Aluguel.listing", query = "SELECT aluguel FROM Aluguel aluguel"),
	@NamedQuery(name="Aluguel.findByCode", query = "SELECT aluguel FROM Aluguel aluguel WHERE aluguel.id = :code")
})
public class Aluguel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alu_codigo")
	private Long id;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "alu_data", nullable = false)
	private Date data;

	@Column(name = "alu_valor_total", precision = 7, scale = 2, nullable = false)
	private BigDecimal valor_total;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_funcioario_fun_codigo", referencedColumnName = "fun_codigo", nullable = false)
	private Funcionario funcionario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_cliente_cli_codigo", referencedColumnName = "cli_codigo", nullable = false)
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_quarto_qua_codigo", referencedColumnName = "qua_codigo", nullable = false)
	private Quarto quarto;

	public Aluguel(){
		
	}
	
	public Aluguel(Date data, BigDecimal valor_total, Funcionario funcionario, Cliente cliente, Quarto quarto) {
		super();
		this.data = data;
		this.valor_total = valor_total;
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.quarto = quarto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValor_total() {
		return valor_total;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	@Override
	public String toString() {
		return "Aluguel [id=" + id + ", data=" + data + ", valor_total=" + valor_total + ", funcionario=" + funcionario
				+ ", cliente=" + cliente + ", quarto=" + quarto + "]";
	}
	
	

}
