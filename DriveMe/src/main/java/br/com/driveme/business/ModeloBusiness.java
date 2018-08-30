package br.com.driveme.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.Modelo;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ModeloBusiness {

	@Autowired
	GenericDao<Modelo> dao;
	
	public Long save(Modelo m) {
		return dao.save(m);
	}
	
	public void delete(Modelo m) {
		dao.delete(m);
	}
	
	public void update(Modelo m) {
		dao.update(m);
	}
	
	public Modelo findById(Long id) {
		return dao.findById(id);
	}
	
	public List<Modelo> list(){
		return dao.list();
	}
}
