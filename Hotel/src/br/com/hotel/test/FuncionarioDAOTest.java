package br.com.hotel.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.hotel.dao.GenericDAO;
import br.com.hotel.domain.Funcionario;

public class FuncionarioDAOTest {

	GenericDAO<Funcionario> dao = new GenericDAO<Funcionario>(new Funcionario());
	Funcionario funcionario;

	@Test
	@Ignore
	public void save(){
		//funcionario = new Funcionario("Silviano", "111111", "11111", "Consultor");
		//funcionario = new Funcionario("Josiano", "2222222", "222222", "Executivo");
		funcionario = new Funcionario("Josilina", "3333333", "333333", "CEO");
		
		dao.save(funcionario);
	}

	@Test
	@Ignore
	public void list() {
		List<Funcionario> funcionarios = dao.Listing();
		System.out.println(funcionarios);
	}

	@Test
	@Ignore
	public void findByCode() {
		funcionario = new Funcionario();
		funcionario = dao.findByCode(1L);
		System.out.println(funcionario);
	}

	@Test
	@Ignore
	public void delete() {
		funcionario = dao.findByCode(3L);
		dao.delete(funcionario);
	}

	@Test
	@Ignore
	public void update() {
		funcionario = dao.findByCode(2L);
		funcionario.setNome("Michael Jackson");
		dao.update(funcionario);
	}
}
