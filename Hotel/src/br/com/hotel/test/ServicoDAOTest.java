package br.com.hotel.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.hotel.dao.GenericDAO;
import br.com.hotel.domain.Servico;

public class ServicoDAOTest {
	GenericDAO<Servico> dao = new GenericDAO<Servico>(new Servico());
	Servico servico;

	@Test
	@Ignore
	public void save(){
		dao.save(new Servico("Café Da Manha", "Serve as 08:00", new BigDecimal(10.00D)));
		dao.save(new Servico("Almoço", "Serve ao 12:00", new BigDecimal(20.00D)));
		dao.save(new Servico("Marmitex", "Pode levar para o quarto", new BigDecimal(15.00D)));
		dao.save(new Servico("Jantar", "Serve as 19:00", new BigDecimal(20.00D)));
		dao.save(new Servico("Wifi - ulta rápida", "", new BigDecimal(05.00D)));
	}

	@Test
	@Ignore
	public void list() {
		List<Servico> servicos = dao.Listing();
		System.out.println(servicos);
	}

	@Test
	@Ignore
	public void findByCode() {
		servico = new Servico();
		servico = dao.findByCode(1L);
		System.out.println(servico);
	}

	@Test
	//@Ignore
	public void delete() {
		servico = dao.findByCode(2L);
		dao.delete(servico);
	}

	@Test
	@Ignore
	public void update() {
		servico = dao.findByCode(2L);
		servico.setDescricao("Sem janela, porão");
		servico.setPreco(new BigDecimal(20.00D));
		dao.update(servico);
	}
}
