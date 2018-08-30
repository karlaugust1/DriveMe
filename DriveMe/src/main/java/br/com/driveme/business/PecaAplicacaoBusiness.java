package br.com.driveme.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.PecaAplicacao;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PecaAplicacaoBusiness {

	@Autowired
	GenericDao<PecaAplicacao> dao;
	
	public Long save(PecaAplicacao pa) {
		return dao.save(pa);
	}
	
	public void delete(PecaAplicacao pa) {
		dao.delete(pa);
	}
	
	public void update(PecaAplicacao pa) {
		dao.update(pa);
	}
	
	public PecaAplicacao findById(Long id) {
		return dao.findById(id);
	}
	
	public List<PecaAplicacao> list(){
		return dao.list();
	}
}
