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
import br.com.driveme.entity.TipoVeiculo;
import br.com.driveme.util.ResponseType;
import br.com.driveme.util.ServiceResponse;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class TipoVeiculoBusiness {

	@Autowired
	GenericDao<TipoVeiculo> dao;
	
	public Long save(TipoVeiculo tu){
		
		System.out.println(this.getClass().getName());

		try {
			dao.save(tu);
			System.out.println("PUTA QUE PARIU!");
        } catch (JDBCException|TransactionException e) {
        	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        	System.out.println(e);
        }
		return null;
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