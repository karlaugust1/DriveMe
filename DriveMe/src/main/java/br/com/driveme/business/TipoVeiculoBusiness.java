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
import br.com.driveme.entity.TipoVeiculo;
import br.com.driveme.util.ResponseType;
import br.com.driveme.util.ServiceResponse;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class TipoVeiculoBusiness {

	@Autowired
	GenericDao<TipoVeiculo> dao;
	
	public ServiceResponse save(TipoVeiculo tipoVeiculo){
				
		Map<String, Object> result = new HashMap<>();
		if(tipoVeiculo.getTiveDescricao() == null || tipoVeiculo.getTiveDescricao().equals("")) {
			return new ServiceResponse(ResponseType.ERROR, "Descrição não enviada", "Descrição não enviada", result);
		}
		
		try {
			
			tipoVeiculo.setTiveIcone("");
			tipoVeiculo.setTiveId(dao.save(tipoVeiculo));	
			result.put("tipoVeiculo", tipoVeiculo);
			return new ServiceResponse(ResponseType.SUCCESS, "Tipo veículo cadastrado com sucesso", "Tipo veículo cadastrado com sucesso", result);
			
        } catch (JDBCException|TransactionException e) {
        	e.printStackTrace();
        	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        	return new ServiceResponse(ResponseType.ERROR, "Erro no banco de dados", "Erro no banco de dados", result);
        } catch (Exception e) {
        	e.printStackTrace();
        	return new ServiceResponse(ResponseType.ERROR, "Erro no banco de dados", "Erro no banco de dados", result);        	
		}
	}
	
	public void delete(TipoVeiculo tp) {
		dao.delete(tp);
	}
	
	public void update(TipoVeiculo tp) {
		dao.update(tp);
	}
	
	public TipoVeiculo findById(Long id) {
		return dao.findById(id);
	}
	
	public ServiceResponse list(){
		Map<String, Object> result = new HashMap<>();
		List<TipoVeiculo> tipoVeiculos = dao.list();
		
		result.put("tipoveiculos", tipoVeiculos);
		return new ServiceResponse(ResponseType.SUCCESS, "Lista de tipos de veículos obtida com sucesso", "Lista de tipos de veículos obtida com sucesso", result);
	}
}