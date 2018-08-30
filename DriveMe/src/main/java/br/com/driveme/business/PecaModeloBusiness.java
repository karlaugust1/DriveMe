package br.com.driveme.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.PecaModelo;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PecaModeloBusiness {

	@Autowired
	GenericDao<PecaModelo> dao;
	
	public Long save(PecaModelo pm) {
		return dao.save(pm);
	}
	
	public void delete(PecaModelo pm) {
		dao.delete(pm);
	}
	
	public void update(PecaModelo pm) {
		dao.update(pm);
	}
	
	public PecaModelo findById(Long id) {
		return dao.findById(id);
	}
	
	public List<PecaModelo> list(){
		return dao.list();
	}
}
