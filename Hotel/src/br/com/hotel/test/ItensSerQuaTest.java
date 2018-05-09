package br.com.hotel.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.hotel.dao.GenericDAO;
import br.com.hotel.domain.Aluguel;
import br.com.hotel.domain.Cliente;
import br.com.hotel.domain.Funcionario;
import br.com.hotel.domain.ItensSerQua;
import br.com.hotel.domain.Quarto;
import br.com.hotel.domain.Reserva;
import br.com.hotel.domain.Servico;

public class ItensSerQuaTest {
	GenericDAO<ItensSerQua> dao = new GenericDAO<ItensSerQua>(new ItensSerQua());
	
	GenericDAO<Aluguel> aluguelDao = new GenericDAO<Aluguel>(new Aluguel());
	GenericDAO<Servico> servicoDao = new GenericDAO<Servico>(new Servico());
	
	ItensSerQua itensSerQua;

	@Test
	@Ignore
	public void save(){
		dao.save(new ItensSerQua("Muito leite", aluguelDao.findByCode(1L), servicoDao.findByCode(1L)));
		dao.save(new ItensSerQua("Suco de Laranja", aluguelDao.findByCode(1L), servicoDao.findByCode(3L)));
		dao.save(new ItensSerQua("Feijoada", aluguelDao.findByCode(1L), servicoDao.findByCode(4L)));
		dao.save(new ItensSerQua("Pão de queijo", aluguelDao.findByCode(2L), servicoDao.findByCode(1L)));
	}

	@Test
	@Ignore
	public void list() {
		List<ItensSerQua> itensSerQua = dao.Listing();
		System.out.println(itensSerQua);
	}

	@Test
	@Ignore
	public void findByCode() {
		itensSerQua = new ItensSerQua();
		itensSerQua = dao.findByCode(1L);
		System.out.println(itensSerQua);
	}

	@Test
	@Ignore
	public void delete() {
		itensSerQua = dao.findByCode(3L);
		dao.delete(itensSerQua);
	}

	@Test
	@Ignore
	public void update() {
		itensSerQua = dao.findByCode(1L);
		itensSerQua.setObs("Quero leite de cabra");
		dao.update(itensSerQua);
	}
}
