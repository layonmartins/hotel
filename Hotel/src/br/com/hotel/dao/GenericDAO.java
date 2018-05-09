package br.com.hotel.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.hotel.util.HibernateUtil;

@SuppressWarnings({ "unchecked", "deprecation" })
public class GenericDAO<T> {

	private Session session;
	private Transaction transaction = null;
	private T myClass;

	
	public GenericDAO() {
		
	}
	
	public GenericDAO(T myClass) {
		super();
		this.myClass = myClass;
	}

	private void openSession() {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = null;
	}

	private void closeSession() {
		session.close();
	}

	public void save(T type) {
		try {
			openSession();
			transaction = session.beginTransaction();
			session.save(type);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			closeSession();
		}
	}

	public List<T> Listing() {
		List<T> types = null;
		try {
			openSession();
			Query<T> result = session.getNamedQuery(myClass.getClass().getSimpleName() + ".listing");
			types = result.list();
		} catch (Exception e) {
			throw e;
		} finally {
			closeSession();
		}
		return types;
	}

	public T findByCode(Long code){
		T type = null;
		try {
			openSession();
			Query<T> result = session.getNamedQuery(myClass.getClass().getSimpleName() + ".findByCode");
			result.setLong("code", code);
			type = (T) result.uniqueResult();
			} catch (Exception e) {
				throw e;
			} finally {
				closeSession();
			}
		return type;
	}
	
	public void delete(T type) {
		try {
			openSession();
			transaction = session.beginTransaction();
			session.delete(type);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			closeSession();
		}
	}
	
	public void update(T type) {
		try {
			openSession();
			transaction = session.beginTransaction();
			session.update(type);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			closeSession();
		}
	}
	
}
