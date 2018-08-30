package br.com.driveme.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.TipoUsuario;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class TipoUsuarioBusiness {

	@Autowired
	GenericDao<TipoUsuario> dao;
	
	public Long save(TipoUsuario tu) {
		return dao.save(tu);
	}
	
	public void delete(TipoUsuario tu) {
		dao.delete(tu);
	}
	
	public void update(TipoUsuario tu) {
		dao.update(tu);
	}
	
	public TipoUsuario findById(Long id) {
		return dao.findById(id);
	}
	
	public List<TipoUsuario> list(){
		return dao.list();
	}
}
