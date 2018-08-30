package br.com.driveme.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.PecaPedido;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PecaPedidoBusiness {

	@Autowired
	GenericDao<PecaPedido> dao;
	
	public Long save(PecaPedido pp) {
		return dao.save(pp);
	}
	
	public void delete(PecaPedido pp) {
		dao.delete(pp);
	}
	
	public void update(PecaPedido pp) {
		dao.update(pp);
	}
	
	public PecaPedido findById(Long id) {
		return dao.findById(id);
	}
	
	public List<PecaPedido> list(){
		return dao.list();
	}
}
