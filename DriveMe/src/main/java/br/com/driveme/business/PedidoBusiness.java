package br.com.driveme.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.Pedido;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PedidoBusiness {

	@Autowired
	GenericDao<Pedido> dao;
	
	public Long save(Pedido p) {
		return dao.save(p);
	}
	
	public void delete(Pedido p) {
		dao.delete(p);
	}
	
	public void update(Pedido p) {
		dao.update(p);
	}
	
	public Pedido findById(Long id) {
		return dao.findById(id);
	}
	
	public List<Pedido> list(){
		return dao.list();
	}
}
