package br.com.driveme.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.PecaCaracteristica;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PecaCaracteristicaBusiness {

	@Autowired
	GenericDao<PecaCaracteristica> dao;
	
	public Long save(PecaCaracteristica p) {
		return dao.save(p);
	}
	
	public void delete(PecaCaracteristica p) {
		dao.delete(p);
	}
	
	public void update(PecaCaracteristica p) {
		dao.update(p);
	}
	
	public PecaCaracteristica findById(Long id) {
		return dao.findById(id);
	}
	
	public List<PecaCaracteristica> list(){
		return dao.list();
	}
}
