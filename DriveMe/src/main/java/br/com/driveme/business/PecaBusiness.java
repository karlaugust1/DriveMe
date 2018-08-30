package br.com.driveme.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.Peca;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PecaBusiness {

	@Autowired
	GenericDao<Peca> dao;
	
	public Long save(Peca p) {
		return dao.save(p);
	}
	
	public void delete(Peca p) {
		dao.delete(p);
	}
	
	public void update(Peca p) {
		dao.update(p);
	}
	
	public Peca findById(Long id) {
		return dao.findById(id);
	}
	
	public List<Peca> list(){
		return dao.list();
	}
}
