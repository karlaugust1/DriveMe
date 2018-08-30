package br.com.driveme.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.Montadora;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class MontadoraBusiness {

	@Autowired
	GenericDao<Montadora> dao;

	public Long save(Montadora m) {
		return dao.save(m);
	}
	
	public void delete(Montadora m) {
		dao.delete(m);
	}
	
	public void update(Montadora m) {
		dao.update(m);
	}
	
	public Montadora findById(Long id) {
		return dao.findById(id);
	}
	
	public List<Montadora> list(){
		return dao.list();
	}
}
