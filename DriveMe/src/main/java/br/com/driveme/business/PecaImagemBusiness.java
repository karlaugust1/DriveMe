package br.com.driveme.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.PecaImagem;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PecaImagemBusiness {

	@Autowired
	GenericDao<PecaImagem> dao;
	
	public Long save(PecaImagem pi) {
		return dao.save(pi);
	}
	
	public void delete(PecaImagem pi) {
		dao.delete(pi);
	}
	
	public void update(PecaImagem pi) {
		dao.update(pi);
	}
	
	public PecaImagem findById(Long id) {
		return dao.findById(id);
	}
	
	public List<PecaImagem> list(){
		return dao.list();
	}
}
