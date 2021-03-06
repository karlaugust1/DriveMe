package br.com.driveme.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.Peca;
import br.com.driveme.entity.PecaAvaliacao;
import br.com.driveme.sorts.SortByPopularity;
import br.com.driveme.sorts.SortByStars;
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

		if (p.getPecaVisualizacao() == null)
			p.setPecaVisualizacao(0);

		p.setPecaId(dao.save(p));

		p.getPecaImagems().forEach(imagem -> {
			imagem.setPeca(p);
			pecaImagemBo.save(imagem);
		});
		/*
		 * p.getAplicacaos().forEach(a -> { System.out.println(a.getApliDescricao());
		 * aplicacaoBo.save(a); });
		 */
		/*
		p.getPecaAvaliacaos().forEach(a -> {
			a.setPeca(p);
			pecaAvaliacaoBo.save(a);
		});
		 */
		p.getPecaCaracteristicas().forEach(c -> {
			c.setPeca(p);
			pecaCaracteristicaBo.save(c);
		});
		
		p.getPecaEspecificacaos().forEach(e -> {
			e.setPeca(p);
			pecaEspecificacaoBo.save(e);
		});
		/*
		 * p.getModelos().forEach( m -> { modeloBo.save(m); });
		 */
		p.getTipoVeiculos().forEach(tp -> {
			System.out.println(tp.getTiveDescricao());
		});

		p.getPecaPedidos().forEach(pp -> {
			pecaPedidoBo.save(pp);
		});

		Map<String, Object> result = new HashMap<>();
		result.put("peca", p);
		return new ServiceResponse(ResponseType.SUCCESS, "Pe�a salva com sucesso", "Pe�a salva com sucesso", result);
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
	
	public List<Peca> list(){
		
		try {
			
			List<Peca> pecas = dao.list();
			List<Peca> pecas1 = new ArrayList<>();
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < pecas.size(); j++) {
					if(i == pecas.get(j).getPecaId()) {
						pecas1.add(pecas.get(j));
						break;						
					}
				}
			}

			pecas1.forEach(p -> {

				String valor = String.valueOf(p.getPecaValor());
				int tamanho = valor.length();
				String centavos = valor.substring(valor.indexOf(".") + 1);
				String principal = valor.substring(0, valor.indexOf("."));
				if(centavos.length() == 1) {
					p.setValorCentavos(centavos.concat("0"));
				}else {
					p.setValorCentavos(valor.substring(tamanho - 2));					
				}
				p.setValorPrincipal(principal);
				p.setEstrelas(this.getEstrelas(p.getPecaAvaliacaos()));
				
			});
			
			return pecas1;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
			
	}

	public ServiceResponse list(Long id) {

		Map<String, Object> result = new HashMap<>();

		if (id != null) {
			Peca peca = dao.findById(id);

			String valor = String.valueOf(peca.getPecaValor());
			int tamanho = valor.length();
			String centavos = valor.substring(valor.indexOf(".") + 1);
			String principal = valor.substring(0, valor.indexOf("."));
			if(centavos.length() == 1) {
				peca.setValorCentavos(centavos.concat("0"));
			}else {
				peca.setValorCentavos(valor.substring(tamanho - 2));					
			}
			peca.setValorPrincipal(principal);
			peca.setEstrelas(this.getEstrelas(peca.getPecaAvaliacaos()));
			this.adicionarVisualizacao(peca);
			result.put("peca", peca);
			
			return new ServiceResponse(ResponseType.SUCCESS, "Peca obtida com sucesso", "Peca obtida com sucesso",
					result);

		} else {

			List<Peca> pecas = dao.list();
			List<Peca> pecas1 = new ArrayList<>();
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < pecas.size(); j++) {
					if(i == pecas.get(j).getPecaId()) {
						pecas1.add(pecas.get(j));
						break;						
					}
				}
			}

			pecas1.forEach(p -> {

				String valor = String.valueOf(p.getPecaValor());
				int tamanho = valor.length();
				String centavos = valor.substring(valor.indexOf(".") + 1);
				String principal = valor.substring(0, valor.indexOf("."));
				if(centavos.length() == 1) {
					p.setValorCentavos(centavos.concat("0"));
				}else {
					p.setValorCentavos(valor.substring(tamanho - 2));					
				}
				p.setValorPrincipal(principal);
				p.setEstrelas(this.getEstrelas(p.getPecaAvaliacaos()));
				
			});

			result.put("pecas", pecas1);
			return new ServiceResponse(ResponseType.SUCCESS, "Lista de pecas obtida com sucesso",
					"Lista de pecas obtida com sucesso", result);
		}
	}
	
	public void adicionarVisualizacao(Peca peca) {
		
		peca.setPecaVisualizacao(peca.getPecaVisualizacao() + 1);
		this.dao.update(peca);
		
	}
	
	public Integer getEstrelas(Set<PecaAvaliacao> set) {
		
		Double i = new Double(0);
		for(PecaAvaliacao pa : set) {
			i += pa.getPeavEstrelas();
		}
		i = i/set.size();
		
		Integer estrelinha = i.intValue();
		if(estrelinha > 5) {
			estrelinha = 5;
		}else if(estrelinha < 0){
			estrelinha = 0;
		}
		return estrelinha;
	}
	
	public ServiceResponse listBestProducts(){
		
		Map<String, Object> result = new HashMap<>();
		
		List<Peca> pecas = dao.list();
		List<Peca> pecas1 = new ArrayList<>();
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < pecas.size(); j++) {
				if(i == pecas.get(j).getPecaId()) {
					pecas.get(j).setEstrelas(this.getEstrelas(pecas.get(j).getPecaAvaliacaos()));
					pecas1.add(pecas.get(j));
					break;						
				}
			}
		}

		Collections.sort(pecas1, new SortByStars()); 
		
		pecas = new ArrayList<Peca>();
		for(int i = 0; i < pecas1.size(); i++) {
			if(i < 6) {
				String valor = String.valueOf(pecas1.get(i).getPecaValor());
				int tamanho = valor.length();
				String centavos = valor.substring(valor.indexOf(".") + 1);
				String principal = valor.substring(0, valor.indexOf("."));
				if(centavos.length() == 1) {
					pecas1.get(i).setValorCentavos(centavos.concat("0"));
				}else {
					pecas1.get(i).setValorCentavos(valor.substring(tamanho - 2));					
				}
				pecas1.get(i).setValorPrincipal(principal);
				pecas1.get(i).setEstrelas(this.getEstrelas(pecas1.get(i).getPecaAvaliacaos()));
				pecas.add(pecas1.get(i));				
			}
		}

		result.put("pecas", pecas);
		return new ServiceResponse(ResponseType.SUCCESS, "Lista de pecas obtida com sucesso", "Lista de pecas obtida com sucesso", result);
	}
	 
	public ServiceResponse listPopularParts(){
		
		Map<String, Object> result = new HashMap<>();
		
		List<Peca> pecas = dao.list();
		List<Peca> pecas1 = new ArrayList<>();
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < pecas.size(); j++) {
				if(i == pecas.get(j).getPecaId()) {
					pecas.get(j).setEstrelas(this.getEstrelas(pecas.get(j).getPecaAvaliacaos()));
					pecas1.add(pecas.get(j));
					break;						
				}
			}
		}

		Collections.sort(pecas1, new SortByPopularity()); 
		pecas = new ArrayList<Peca>();

		for(int i = 0; i < pecas1.size(); i++) {
			if(i <6) {
				String valor = String.valueOf(pecas1.get(i).getPecaValor());
				int tamanho = valor.length();
				String centavos = valor.substring(valor.indexOf(".") + 1);
				String principal = valor.substring(0, valor.indexOf("."));
				if(centavos.length() == 1) {
					pecas1.get(i).setValorCentavos(centavos.concat("0"));
				}else {
					pecas1.get(i).setValorCentavos(valor.substring(tamanho - 2));					
				}
				pecas1.get(i).setValorPrincipal(principal);
				pecas1.get(i).setEstrelas(this.getEstrelas(pecas1.get(i).getPecaAvaliacaos()));
				pecas.add(pecas1.get(i));
				
			}
		}

		result.put("pecas", pecas);
		return new ServiceResponse(ResponseType.SUCCESS, "Lista de pecas obtida com sucesso", "Lista de pecas obtida com sucesso", result);
	}
}
