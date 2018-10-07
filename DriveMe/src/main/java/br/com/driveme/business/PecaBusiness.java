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
	
	/* ODEIO O HIBERNATE */
	@Autowired
	PecaImagemBusiness pecaImagemBo;
	
	@Autowired
	AplicacaoBusiness aplicacaoBo;
	
	@Autowired
	PecaAvaliacaoBusiness pecaAvaliacaoBo;
	
	@Autowired
	PecaCaracteristicaBusiness pecaCaracteristicaBo;
	
	@Autowired
	PecaEspecificacaoBusiness pecaEspecificacaoBo;
	
	@Autowired
	ModeloBusiness modeloBo;
	
	@Autowired
	TipoVeiculoBusiness tipoVeiculoBo;
	
	@Autowired
	PecaPedidoBusiness pecaPedidoBo;
	/* FIM ODEIO O HIBERNATE */

	
	public ServiceResponse save(Peca p) {
		
		if(p.getPecaVisualizacao() == null)
			p.setPecaVisualizacao(0);
		
		p.setPecaId(dao.save(p));
		
		p.getPecaImagems().forEach( imagem -> {
			imagem.setPeca(p);
			pecaImagemBo.save(imagem);
		});
		/*
		p.getAplicacaos().forEach(a -> {
			System.out.println(a.getApliDescricao());
			aplicacaoBo.save(a);
		});
		*/
		p.getPecaAvaliacaos().forEach( a -> {
			a.setPeca(p);
			pecaAvaliacaoBo.save(a);
		});
		
		p.getPecaCaracteristicas().forEach( c -> {
			c.setPeca(p);
			pecaCaracteristicaBo.save(c);
		});
		
		p.getPecaEspecificacaos().forEach( e -> {
			e.setPeca(p);
			pecaEspecificacaoBo.save(e);
		});
		/*
		p.getModelos().forEach( m -> {
			modeloBo.save(m);
		});
		*/
		p.getTipoVeiculos().forEach( tp -> {
			System.out.println(tp.getTiveDescricao());
		});
		
		p.getPecaPedidos().forEach( pp -> {
			pecaPedidoBo.save(pp);
		});
		
		Map<String, Object> result = new HashMap<>();
		result.put("peca", p);
		return new ServiceResponse(ResponseType.SUCCESS,"Peça salva com sucesso","Peça salva com sucesso",result);
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
