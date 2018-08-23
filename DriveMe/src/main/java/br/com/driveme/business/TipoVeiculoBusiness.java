package br.com.driveme.business;

import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.TipoVeiculo;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class TipoVeiculoBusiness {

	@Autowired
	GenericDao<TipoVeiculo> tipoVeiculoDao;
	
	public void save(TipoVeiculo tu){
		
		System.out.println(this.getClass().getName());

		try {
			tipoVeiculoDao.save(tu);
			System.out.println("PUTA QUE PARIU!");
        } catch (JDBCException|TransactionException e) {
        	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        	System.out.println(e);
        }
	}
}