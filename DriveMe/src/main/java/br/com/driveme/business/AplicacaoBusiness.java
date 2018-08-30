package br.com.driveme.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.Aplicacao;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class AplicacaoBusiness {

	@Autowired
	GenericDao<Aplicacao> dao;
	
	public Long save(Aplicacao a) {
		return dao.save(a);
	}
	
	public void delete(Aplicacao a) {
		dao.delete(a);
	}
	
	public void update(Aplicacao a) {
		dao.update(a);
	}
	
	public Aplicacao findById(Long id) {
		return dao.findById(id);
	}
	
	public List<Aplicacao> list(){
		return dao.list();
	}
}
