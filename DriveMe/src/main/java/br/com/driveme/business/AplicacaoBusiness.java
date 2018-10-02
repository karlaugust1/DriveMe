package br.com.driveme.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.Aplicacao;
import br.com.driveme.util.ResponseType;
import br.com.driveme.util.ServiceResponse;

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
	
	public ServiceResponse list(){
		
		Map<String, Object> result = new HashMap<>();
		List<Aplicacao> aplicacoes = dao.list();
		
		result.put("aplicacoes", aplicacoes);
		return new ServiceResponse(ResponseType.SUCCESS, "Lista de aplicações obtida com sucesso", "Lista de aplicações obtida com sucesso", result);
	}
}
