package br.com.driveme.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.UsuarioAvaliacao;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class UsuarioAvaliacaoBusiness {

	@Autowired
	GenericDao<UsuarioAvaliacao> dao;
	
	public Long save(UsuarioAvaliacao ua) {
		return dao.save(ua);
	}
	
	public void delete(UsuarioAvaliacao ua) {
		dao.delete(ua);
	}
	
	public void update(UsuarioAvaliacao ua) {
		dao.update(ua);
	}
	
	public UsuarioAvaliacao findById(Long id) {
		return dao.findById(id);
	}
	
	public List<UsuarioAvaliacao> list(){
		return dao.list();
	}
}
