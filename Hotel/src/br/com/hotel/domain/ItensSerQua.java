package br.com.hotel.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_intes_ser_qua")
public class ItensSerQua {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ite_codigo")
	private Long codigo;

	@Column(name = "ite_obs", length = 100)
	private String obs;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_aluguel_alu_codigo", referencedColumnName = "alu_codigo", nullable = false)
	private Aluguel aluguel;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_servico_ser_codigo", referencedColumnName = "ser_codigo", nullable = false)
	private Servico servico;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}
