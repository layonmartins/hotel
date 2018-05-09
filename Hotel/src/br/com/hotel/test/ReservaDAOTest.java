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
import br.com.hotel.domain.Reserva;

public class ReservaDAOTest {
	GenericDAO<Reserva> dao = new GenericDAO<Reserva>(new Reserva());
	GenericDAO<Cliente> clienteDao = new GenericDAO<Cliente>(new Cliente());
	GenericDAO<Funcionario> funcionarioDao = new GenericDAO<Funcionario>(new Funcionario());
	GenericDAO<Quarto> quartoDao = new GenericDAO<Quarto>(new Quarto());
	
	Reserva reserva;

	@Test
	@Ignore
	public void save(){
		//dao.save(new Reserva(new Date(), clienteDao.findByCode(1L), funcionarioDao.findByCode(1L), quartoDao.findByCode(1L)));
		//dao.save(new Reserva(new Date(), clienteDao.findByCode(2L), funcionarioDao.findByCode(1L), quartoDao.findByCode(2L)));
		dao.save(new Reserva(new Date(), clienteDao.findByCode(1L), funcionarioDao.findByCode(2L), quartoDao.findByCode(4L)));
	}

	@Test
	@Ignore
	public void list() {
		List<Reserva> reservas = dao.Listing();
		System.out.println(reservas);
	}

	@Test
	@Ignore
	public void findByCode() {
		reserva = new Reserva();
		reserva = dao.findByCode(1L);
		System.out.println(reserva);
	}

	@Test
	@Ignore
	public void delete() {
		reserva = dao.findByCode(2L);
		dao.delete(reserva);
	}

	@Test
	@Ignore
	public void update() {
		reserva = dao.findByCode(1L);
		reserva.setData(new Date());
		dao.update(reserva);
	}
}
