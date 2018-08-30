package br.com.driveme.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.MontadoraTipoVeiculo;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class MontadoraTipoVeiculoBusiness {

	@Autowired
	GenericDao<MontadoraTipoVeiculo> dao;
	
	public Long save(MontadoraTipoVeiculo m) {
		return dao.save(m);
	}
	
	public void delete(MontadoraTipoVeiculo m) {
		dao.delete(m);
	}
	
	public void update(MontadoraTipoVeiculo m) {
		dao.update(m);
	}
	
	public MontadoraTipoVeiculo findById(Long id) {
		return dao.findById(id);
	}
	
	public List<MontadoraTipoVeiculo> list(){
		return dao.list();
	}	
}
