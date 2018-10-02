package br.com.driveme.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDao<T> implements Dao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	private final Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public GenericDao() {
		this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public T findById(Serializable id) {
		return (T) getCurrentSession().load(this.entityClass, id);
	}

	public Long save(Object t) {
		Long i = (Long) getCurrentSession().save(t);
		return i;
	}

	public void delete(Object t) {
		getCurrentSession().delete(t);
	}

	public void update(Object t) {
		getCurrentSession().update(t);
		
	}

	@SuppressWarnings("unchecked")
	public List<T> list() {
		return getCurrentSession().createCriteria(this.entityClass).list();
	}
	
	public Long getLastId() {
		Long lastId = ((BigInteger) getCurrentSession().createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
		return lastId;
	}

}
