package br.com.driveme.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.Usuario;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class UsuarioBusiness {

	@Autowired
	GenericDao<Usuario> dao;
	
	public Long save(Usuario u) {
		return dao.save(u);
	}
	
	public void delete(Usuario u) {
		dao.delete(u);
	}
	
	public void update(Usuario u) {
		dao.update(u);
	}
	
	public Usuario findById(Long id) {
		return dao.findById(id);
	}
	
	public List<Usuario> list(){
		return dao.list();
	}
}
