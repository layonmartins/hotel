package br.com.hotel.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.hotel.dao.GenericDAO;
import br.com.hotel.domain.Cliente;
import br.com.hotel.domain.Funcionario;
import br.com.hotel.domain.Quarto;
import br.com.hotel.domain.Aluguel;

public class AluguelDAOTest {

	GenericDAO<Aluguel> dao = new GenericDAO<Aluguel>(new Aluguel());
	GenericDAO<Cliente> clienteDao = new GenericDAO<Cliente>(new Cliente());
	GenericDAO<Funcionario> funcionarioDao = new GenericDAO<Funcionario>(new Funcionario());
	GenericDAO<Quarto> quartoDao = new GenericDAO<Quarto>(new Quarto());
	
	Aluguel aluguel;

	@Test
	@Ignore
	public void save(){
		dao.save(new Aluguel(new Date(), new BigDecimal(100.00D), funcionarioDao.findByCode(1L), clienteDao.findByCode(1L), quartoDao.findByCode(1L)));
		dao.save(new Aluguel(new Date(), new BigDecimal(80.00D), funcionarioDao.findByCode(2L), clienteDao.findByCode(2L), quartoDao.findByCode(4L)));
		dao.save(new Aluguel(new Date(), new BigDecimal(90.00D), funcionarioDao.findByCode(2L), clienteDao.findByCode(3L), quartoDao.findByCode(1L)));
	}

	@Test
	@Ignore
	public void list() {
		List<Aluguel> alugueis = dao.Listing();
		System.out.println(alugueis);
	}

	@Test
	@Ignore
	public void findByCode() {
		aluguel = new Aluguel();
		aluguel = dao.findByCode(1L);
		System.out.println(aluguel);
	}

	@Test
	@Ignore
	public void delete() {
		aluguel = dao.findByCode(3L);
		dao.delete(aluguel);
	}

	@Test
	@Ignore
	public void update() {
		aluguel = dao.findByCode(1L);
		aluguel.setData(new Date());
		dao.update(aluguel);
	}
}
