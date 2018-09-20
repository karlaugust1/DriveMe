package br.com.driveme.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.Peca;
import br.com.driveme.util.ResponseType;
import br.com.driveme.util.ServiceResponse;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PecaBusiness {

	@Autowired
	GenericDao<Peca> dao;
	
	public Long save(Peca p) {
		return dao.save(p);
	}
	
	public void delete(Peca p) {
		dao.delete(p);
	}
	
	public void update(Peca p) {
		dao.update(p);
	}
	
	public Peca findById(Long id) {
		return dao.findById(id);
	}
	
	public ServiceResponse list(){
		
		Map<String, Object> result = new HashMap<>();
		List<Peca> pecas = dao.list();
		
		pecas.forEach(p ->{
			
			String valor = String.valueOf(p.getPecaValor());
			int tamanho = valor.length();
			p.setValorPrincipal(valor.substring(0, tamanho - 3));
			p.setValorCentavos(valor.substring(tamanho -2));
			
		});
		
		result.put("pecas", pecas);
		return new ServiceResponse(ResponseType.SUCCESS, "Lista de pecas obtida com sucesso", "Lista de pecas obtida com sucesso", result);
	}
}
