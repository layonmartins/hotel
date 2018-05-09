package br.com.hotel.domain;

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

@Entity
@Table(name = "tbl_intes_ser_qua")
@NamedQueries({
	@NamedQuery(name="ItensSerQua.listing", query = "SELECT itensSerQua FROM ItensSerQua itensSerQua"),
	@NamedQuery(name="ItensSerQua.findByCode", query = "SELECT itensSerQua FROM ItensSerQua itensSerQua WHERE itensSerQua.id = :code")
})
public class ItensSerQua {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ite_codigo")
	private Long id;

	@Column(name = "ite_obs", length = 100)
	private String obs;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_aluguel_alu_codigo", referencedColumnName = "alu_codigo", nullable = false)
	private Aluguel aluguel;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_servico_ser_codigo", referencedColumnName = "ser_codigo", nullable = false)
	private Servico servico;

	public ItensSerQua(){
		
	}
	
	public ItensSerQua(String obs, Aluguel aluguel, Servico servico) {
		super();
		this.obs = obs;
		this.aluguel = aluguel;
		this.servico = servico;
	}


	public Long getCodigo() {
		return id;
	}

	public void setCodigo(Long codigo) {
		this.id = codigo;
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

	@Override
	public String toString() {
		return "ItensSerQua [id=" + id + ", obs=" + obs + ", aluguel=" + aluguel + ", servico=" + servico + "]";
	}

	
}
