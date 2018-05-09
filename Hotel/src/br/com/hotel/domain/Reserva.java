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
@Table(name = "tbl_reserva")
@NamedQueries({
	@NamedQuery(name="Reserva.listing", query = "SELECT reserva FROM Reserva reserva"),
	@NamedQuery(name="Reserva.findByCode", query = "SELECT reserva FROM Reserva reserva WHERE reserva.id = :code")
})
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "res_codigo")
	private Long codigo;
	
	
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

	public Reserva(){
		
	}
	
	public Reserva(Date data, Cliente cliente, Funcionario funcionario, Quarto quarto) {
		super();
		this.data = data;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.quarto = quarto;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	@Override
	public String toString() {
		return "Reserva [codigo=" + codigo + ", data=" + data + ", cliente=" + cliente
				+ ", funcionario=" + funcionario + ", quarto=" + quarto + "]";
	}
	
	
	
}
