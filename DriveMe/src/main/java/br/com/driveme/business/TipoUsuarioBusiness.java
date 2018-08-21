package br.com.driveme.business;

import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.annotation.Propagation;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.TipoUsuario;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class TipoUsuarioBusiness {

	@Autowired
	GenericDao<TipoUsuario> tipoUsuarioDao;
	
	public void save(TipoUsuario tipoUsuario){
		
		System.out.println(this.getClass().getName());

		try {
			tipoUsuarioDao.save(tipoUsuario);
			System.out.println("PUTA QUE PARIU!");
        } catch (JDBCException|TransactionException e) {
        	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        	System.out.println(e);
        }
	}
}