package br.com.hotel.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.hotel.dao.GenericDAO;
import br.com.hotel.domain.Quarto;

public class QuartoDAOTest {
	
	GenericDAO<Quarto> dao = new GenericDAO<Quarto>(new Quarto());
	Quarto quarto;

	@Test
	@Ignore
	public void save(){
		
		quarto = new Quarto("1A", 1, true, true, "Ótimo quarto para oração", 10, new BigDecimal(50.00D));
		//dao.save(quarto);
		dao.save(new Quarto("2A", 1, true, true, "sem janela", 10, new BigDecimal(30.00D)));
		dao.save(new Quarto("3A", 1, false, true, "Parede azul", 10, new BigDecimal(40.00D)));
		dao.save(new Quarto("4A", 2, true, true, "colção macio", 12, new BigDecimal(50.00D)));
		dao.save(new Quarto("1B", 1, true, false, "escrevaninha", 10, new BigDecimal(50.00D)));
		dao.save(new Quarto("1B", 2, true, true, "Sacada", 12, new BigDecimal(80.00D)));
	}

	@Test
	@Ignore
	public void list() {
		List<Quarto> quartos = dao.Listing();
		System.out.println(quartos);
	}

	@Test
	@Ignore
	public void findByCode() {
		quarto = new Quarto();
		quarto = dao.findByCode(1L);
		System.out.println(quarto);
	}

	@Test
	@Ignore
	public void delete() {
		quarto = dao.findByCode(3L);
		dao.delete(quarto);
	}

	@Test
	@Ignore
	public void update() {
		quarto = dao.findByCode(2L);
		quarto.setDescricao("Sem janela, porão");
		quarto.setPreco(new BigDecimal(20.00D));
		dao.update(quarto);
	}
}
