package br.com.driveme.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.PecaAvaliacao;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PecaAvaliacaoBusiness {

	@Autowired
	GenericDao<PecaAvaliacao> dao;
	
	public Long save(PecaAvaliacao pa) {
		return dao.save(pa);
	}
	
	public void delete(PecaAvaliacao pa) {
		dao.delete(pa);
	}
	
	public void update(PecaAvaliacao pa) {
		dao.update(pa);
	}
	
	public PecaAvaliacao findById(Long id) {
		return dao.findById(id);
	}
	
	public List<PecaAvaliacao> list(){
		return dao.list();
	}
}
