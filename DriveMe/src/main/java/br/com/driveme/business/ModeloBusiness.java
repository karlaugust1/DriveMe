package br.com.driveme.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.Modelo;
import br.com.driveme.entity.Montadora;
import br.com.driveme.util.ResponseType;
import br.com.driveme.util.ServiceResponse;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ModeloBusiness {

	@Autowired
	GenericDao<Modelo> dao;
	
	public ServiceResponse save(Modelo modelo) {
		
		Map<String, Object> result = new HashMap<>();
		if(modelo.getModeDescricao() == null || modelo.getModeDescricao().equals("")) {
			return new ServiceResponse(ResponseType.ERROR, "Descrição não enviada", "Descrição não enviada", result);
		}
		
		if(modelo.getModeAno() <= 0 || modelo.getModeAno() == null) {
			return new ServiceResponse(ResponseType.ERROR, "Ano não enviado", "Ano não enviado", result);
		}
		
		if (modelo.getModeId() == null) {
			return new ServiceResponse(ResponseType.ERROR, "Montadora não enviada", "Montadora não enviada", result);
		}
		
		try {
			modelo.setMontadora(new Montadora(modelo.getModeId(), "", ""));
			modelo.setModeId(null);
			modelo.setModeIcone("");
			modelo.setModeId(dao.save(modelo));	
			result.put("modelo", modelo);
			return new ServiceResponse(ResponseType.SUCCESS, "Modelo cadastrado com sucesso", "Modelo cadastrado com sucesso", result);
			
        } catch (JDBCException|TransactionException e) {
        	e.printStackTrace();
        	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        	return new ServiceResponse(ResponseType.ERROR, "Erro no banco de dados", "Erro no banco de dados", result);
        } catch (Exception e) {
        	e.printStackTrace();
        	return new ServiceResponse(ResponseType.ERROR, "Erro no banco de dados", "Erro no banco de dados", result);        	
		}
	}
	
	public void delete(Modelo m) {
		dao.delete(m);
	}
	
	public void update(Modelo m) {
		dao.update(m);
	}
	
	public Modelo findById(Long id) {
		return dao.findById(id);
	}
	
	public ServiceResponse list(){
		Map<String, Object> result = new HashMap<>();
		List<Modelo> modelos = dao.list();
		
		result.put("modelos", modelos);
		return new ServiceResponse(ResponseType.SUCCESS, "Lista de modelos obtida com sucesso", "Lista de modelos obtida com sucesso", result);
	}
}
