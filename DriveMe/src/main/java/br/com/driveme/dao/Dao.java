package br.com.driveme.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {
	
	T findById(Serializable id);
	Long save(T t);
	void delete (T t);
	void update(T t);
	List<T> list();
	
}
