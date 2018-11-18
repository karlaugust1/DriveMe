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
import br.com.driveme.entity.Aplicacao;
import br.com.driveme.util.ResponseType;
import br.com.driveme.util.ServiceResponse;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class AplicacaoBusiness {

	@Autowired
	GenericDao<Aplicacao> dao;
	
	public ServiceResponse save(Aplicacao aplicacao) {
		
		Map<String, Object> result = new HashMap<>();
		if(aplicacao.getApliDescricao() == null || aplicacao.getApliDescricao().equals("")) {
			return new ServiceResponse(ResponseType.ERROR, "Descrição não enviada", "Descrição não enviada", result);
		}
		
		try {
			
			aplicacao.setApliIcone("zmdi-settings");
			aplicacao.setApliId(dao.save(aplicacao));	
			result.put("aplicacao", aplicacao);
			return new ServiceResponse(ResponseType.SUCCESS, "Aplicação cadastrado com sucesso", "Aplicação cadastrado com sucesso", result);
			
        } catch (JDBCException|TransactionException e) {
        	e.printStackTrace();
        	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        	return new ServiceResponse(ResponseType.ERROR, "Erro no banco de dados", "Erro no banco de dados", result);
        } catch (Exception e) {
        	e.printStackTrace();
        	return new ServiceResponse(ResponseType.ERROR, "Erro no banco de dados", "Erro no banco de dados", result);        	
		}
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
