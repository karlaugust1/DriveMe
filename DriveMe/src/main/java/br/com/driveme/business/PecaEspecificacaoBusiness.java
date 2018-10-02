package br.com.driveme.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.PecaEspecificacao;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PecaEspecificacaoBusiness {

	@Autowired
	GenericDao<PecaEspecificacao> dao;
	
	public Long save(PecaEspecificacao p) {
		return dao.save(p);
	}
	
	public void delete(PecaEspecificacao p) {
		dao.delete(p);
	}
	
	public void update(PecaEspecificacao p) {
		dao.update(p);
	}
	
	public PecaEspecificacao findById(Long id) {
		return dao.findById(id);
	}
	
	public List<PecaEspecificacao> list(){
		return dao.list();
	}
}
