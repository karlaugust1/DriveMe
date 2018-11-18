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
import br.com.driveme.entity.Montadora;
import br.com.driveme.util.ResponseType;
import br.com.driveme.util.ServiceResponse;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class MontadoraBusiness {

	@Autowired
	GenericDao<Montadora> dao;

	public ServiceResponse save(Montadora montadora) {
		
		Map<String, Object> result = new HashMap<>();
		if(montadora.getMontDescricao() == null || montadora.getMontDescricao().equals("")) {
			return new ServiceResponse(ResponseType.ERROR, "Descrição não enviada", "Descrição não enviada", result);
		}
		
		try {
			
			montadora.setMontIcone("");
			montadora.setMontId(dao.save(montadora));	
			result.put("montadora", montadora);
			return new ServiceResponse(ResponseType.SUCCESS, "Montadora cadastrado com sucesso", "Montadora cadastrado com sucesso", result);
			
        } catch (JDBCException|TransactionException e) {
        	e.printStackTrace();
        	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        	return new ServiceResponse(ResponseType.ERROR, "Erro no banco de dados", "Erro no banco de dados", result);
        } catch (Exception e) {
        	e.printStackTrace();
        	return new ServiceResponse(ResponseType.ERROR, "Erro no banco de dados", "Erro no banco de dados", result);        	
		}
	}
	
	public void delete(Montadora m) {
		dao.delete(m);
	}
	
	public void update(Montadora m) {
		dao.update(m);
	}
	
	public Montadora findById(Long id) {
		return dao.findById(id);
	}
	
	public ServiceResponse list(){
		
		Map<String, Object> result = new HashMap<>();
		List<Montadora> montadoras = dao.list();
		montadoras.remove(0);
		montadoras.remove(0);
		montadoras.remove(2);
		result.put("montadoras", montadoras);
		return new ServiceResponse(ResponseType.SUCCESS, "Lista de monstadoras obtida com sucesso", "Lista de monstadoras obtida com sucesso", result);
	}
}
