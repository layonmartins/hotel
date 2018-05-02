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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "res_codigo")
	private Long codigo;
	
	@Column(name = "res_preco", precision = 7, scale = 2, nullable = false)
	private BigDecimal preco;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "res_data", nullable = false)
	private Date data;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_cliente_cli_codigo", referencedColumnName = "cli_codigo", nullable = false)
	private Cliente cliente;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_funcionario_fun_codigo", referencedColumnName = "fun_codigo", nullable = false)
	private Funcionario funcionario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_quarto_qua_codigo", referencedColumnName = "qua_codigo", nullable = false)
	private Quarto quarto;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	
	
}
