package br.com.hotel.test;


import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.hotel.dao.GenericDAO;
import br.com.hotel.domain.Cliente;

public class ClienteDAOTest {

	GenericDAO<Cliente> dao = new GenericDAO<Cliente>(new Cliente());
	
	@Test
	@Ignore
	public void save(){
		Cliente cliente = new Cliente("Jose", "333333", "Analista");
		dao.save(cliente);
	}
	
	@Test
	@Ignore
	public void list(){
		List<Cliente> clientes = dao.Listing();
		System.out.println(clientes);
	}
	
	@Test
	@Ignore
	public void findByCode(){
		Cliente cliente = new Cliente();
		cliente = dao.findByCode(1L);
		System.out.println(cliente);
	}
	
	@Test
	@Ignore
	public void delete(){
		Cliente cliente = dao.findByCode(4L);
		dao.delete(cliente);
	}
	
	@Test
	@Ignore
	public void update(){
		Cliente cliente = dao.findByCode(3L);
		cliente.setNome("José Ailton");
		dao.update(cliente);
	}
	
}
