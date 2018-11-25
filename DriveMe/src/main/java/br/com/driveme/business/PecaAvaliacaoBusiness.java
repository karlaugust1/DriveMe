package br.com.driveme.business;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.dao.UsuarioDaoImpl;
import br.com.driveme.entity.Peca;
import br.com.driveme.entity.PecaAvaliacao;
import br.com.driveme.entity.Usuario;
import br.com.driveme.util.ResponseType;
import br.com.driveme.util.ServiceResponse;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PecaAvaliacaoBusiness {

	@Autowired
	GenericDao<PecaAvaliacao> dao;
	
	@Autowired
	UsuarioDaoImpl usuarioDao;
	
	public ServiceResponse save(PecaAvaliacao pa) {
		Map<String, Object> result = new HashMap<>();
		
		
		Peca peca = new Peca();
		peca.setPecaId(pa.getIdPeca());
		pa.setPeca(peca);
		pa.setPeavData(new Date());
		pa.setPeavId(dao.save(pa));
		Usuario usuario = new Usuario();
		usuario = usuarioDao.findById(pa.getUsuario().getUsuaId());
		pa = dao.findById(pa.getPeavId());
		pa.setUsuario(usuario);
		result.put("avaliacao", pa);
		return new ServiceResponse(ResponseType.SUCCESS, "Avaliação realizada com sucesso", "Avaliação realizada com sucesso", result);
	}
	
	public void delete(PecaAvaliacao pa) {
		dao.delete(pa);
	}
	
	public void update(PecaAvaliacao pa) {
		dao.update(pa);
	}
	
	public PecaAvaliacao findById(Long id) {
		return dao.findById(id);
	}
	
	public List<PecaAvaliacao> list(){
		return dao.list();
	}
}
