package br.com.driveme.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.Peca;
import br.com.driveme.entity.Pedido;
import br.com.driveme.entity.Usuario;
import br.com.driveme.entity.PecaPedido;
import br.com.driveme.util.ResponseType;
import br.com.driveme.util.ServiceResponse;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PedidoBusiness {

	@Autowired
	GenericDao<Pedido> dao;
	
	@Autowired
	PecaPedidoBusiness pecaPedidoBusiness;
	
	@Autowired
	PecaBusiness pecaBusiness;
	
	public ServiceResponse adicionarPeca(Peca p, Long idUsuario) {
		
		Map<String, Object> result = new HashMap<>();
		
		try {
				
			List<Pedido> pedidos = dao.list();
			Pedido pedido = new Pedido();
			
			for(int i = 0; i < pedidos.size(); i++) {
				if(pedidos.get(i).getUsuario().getUsuaId() == idUsuario && pedidos.get(i).getPediAberto() == 1) {
					pedido = pedidos.get(i);
					break;
				}
			}
			
			if(pedido.getPediId() == null) {
				pedido.setUsuario(new Usuario(idUsuario, null));
				pedido.setPediData(new Date());
				pedido.setPediSubtotal(new Double(0));
				pedido.setPediTotal(new Double(0));
				pedido.setPediAberto(new Byte("1"));
				pedido.setPediId(dao.save(pedido));
			}
			
			PecaPedido pecaPedido = new PecaPedido(null, p, pedido, 1, p.getPecaValor());
			pecaPedidoBusiness.save(pecaPedido);
			
			pedido.setPediTotal(pedido.getPediTotal() + p.getPecaValor());
			pedido.setPediSubtotal(pedido.getPediSubtotal() + p.getPecaValor());
			
			dao.update(pedido);
			
			result.put("pedido", pedido);
			return new ServiceResponse(ResponseType.SUCCESS, "Peca adicionada com sucesso", "Peca adicionada com sucesso", result);
			
		} catch (Exception e) {
			return new ServiceResponse(ResponseType.ERROR, "Erro ao adicionar peça ao carrinho", e.getMessage(), result);
		}
	}
	
	public ServiceResponse removerPeca(Pedido pedido, Long idPecaPedido) {
		
		Map<String, Object> result = new HashMap<>();
		
		try {
			
			PecaPedido pecaPedido = pecaPedidoBusiness.findById(idPecaPedido);			
			pecaPedidoBusiness.delete(pecaPedido);
			
			pedido.setPediTotal(pedido.getPediTotal() - pecaPedido.getPepeSubtotal());
			pedido.setPediSubtotal(pedido.getPediSubtotal() - pecaPedido.getPepeSubtotal());
			
			dao.update(pedido);
			
			result.put("pedido", pedido);
			return new ServiceResponse(ResponseType.SUCCESS, "Peca removida com sucesso", "Peca removida com sucesso", result);
			
		} catch (Exception e) {
			return new ServiceResponse(ResponseType.ERROR, "Erro ao removida peça do carrinho", e.getMessage(), result);
		}
		
	}
	
	public void delete(Pedido p) {
		dao.delete(p);
	}
	
	public void update(Pedido p) {
		dao.update(p);
	}
	
	public Pedido findById(Long id) {
		return dao.findById(id);
	}
	
	public ServiceResponse listById(Long id){
		Map<String, Object> result = new HashMap<>();
		result.put("pedidos", dao.list());
		return new ServiceResponse(ResponseType.SUCCESS, "Pedidos obtidos com sucesso", "Pedidos obtidos com sucesso", result);
	}
	
	public List<Pedido> list(){
		return dao.list();
	}
	
	public ServiceResponse findByUsuarioId(Long idUsuario) {
		
		Map<String, Object> result = new HashMap<>();
		
		try {			
						
			List<Pedido> pedidos = dao.list();
			Pedido pedido = new Pedido();
			
			for(int i = 0; i < pedidos.size(); i++) {
				if(pedidos.get(i).getUsuario().getUsuaId() == idUsuario && pedidos.get(i).getPediAberto() == 1) {
					pedido = pedidos.get(i);
					break;
				}
			}
			
			List<Peca> pecas = pecaBusiness.list();
			List<Peca> pecasPedido = new ArrayList<>();
			List<PecaPedido> lista = new ArrayList<>();
			lista.addAll(pedido.getPecaPedidos());
			
			for(int i = 0; i < lista.size(); i++) {
				for(int j = 0; j < pecas.size(); j++) {
					if( lista.get(i).getPeca().getPecaId() == pecas.get(j).getPecaId()) {
						pecasPedido.add(pecas.get(j));
						break;						
					}
				}
			}
			result.put("pecas", pecasPedido);
			result.put("pedido", pedido);
			return new ServiceResponse(ResponseType.SUCCESS, "Pedido obtido com sucesso", "Pedido obtido com sucesso", result);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ServiceResponse(ResponseType.ERROR, "Erro ao obter pedido", e.getMessage(), result);
		}
		
	}
	
	public Double getFaturamento() {
				
		Double faturamento = new Double(0);
		List<Pedido> pedidos = dao.list();
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < pedidos.size(); j++) {
				if(i == pedidos.get(j).getPediId()) {
					faturamento += pedidos.get(j).getPediTotal();
					break;						
				}
			}
		}
		
		return faturamento;
		
	}

	public ServiceResponse finalizarPedido(Pedido pedido) {
		
		Map<String, Object> result = new HashMap<>();
		
		try {
			
			pedido = dao.findById(pedido.getPediId());
			pedido.setPediAberto(new Byte("0"));
			
			dao.update(pedido);
			
			result.put("pedido", pedido);
			return new ServiceResponse(ResponseType.SUCCESS, "Pedido finalizado com sucesso", "Pedido finalizado com sucesso", result);
			
		} catch (Exception e) {
			return new ServiceResponse(ResponseType.ERROR, "Erro ao finalizar pedido", e.getMessage(), result);
		}
		
	}

	public ServiceResponse findFinalizadosByUsuarioId(Long idUsuario) {
		
		System.out.println("entrou nesse método escroto");
		
		Map<String, Object> result = new HashMap<>();
		
		try {			
						
			List<Pedido> pedidos = dao.list();
			List<Pedido> pedidosFinalizados = new ArrayList<>();
			
			for(int j = 0; j < 100; j++) {
				for(int i = 0; i < pedidos.size(); i++) {
					if(j == pedidos.get(i).getPediId()) {
						if(pedidos.get(i).getUsuario().getUsuaId() == idUsuario && pedidos.get(i).getPediAberto() == 0) {
							pedidosFinalizados.add(pedidos.get(i));
						}					
					}
				}				
			}
			
			List<Pedido> pedidosFinalizados2 = new ArrayList<>();
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < pedidosFinalizados.size(); j++) {
					if(i == pedidosFinalizados.get(j).getPediId()) {
						pedidosFinalizados2.add(pedidosFinalizados.get(j));
						break;						
					}
				}
			}
			
			List<List<Peca>> listaPecasPedido = new ArrayList<>();
			List<Peca> pecas = pecaBusiness.list();
			
			for(Pedido pedido : pedidosFinalizados2) {
				
				List<PecaPedido> lista = new ArrayList<>();
				lista.addAll(pedido.getPecaPedidos());
				List<Peca> pecasPedido = new ArrayList<>();
				
				for(int i = 0; i < lista.size(); i++) {
					for(int j = 0; j < pecas.size(); j++) {
						if( lista.get(i).getPeca().getPecaId() == pecas.get(j).getPecaId()) {
							pecasPedido.add(pecas.get(j));
							break;						
						}
					}
				}
				
				listaPecasPedido.add(pecasPedido);
				
			}
			
			result.put("pecas", listaPecasPedido);
			result.put("pedidos", pedidosFinalizados2);
			return new ServiceResponse(ResponseType.SUCCESS, "Pedidos obtidos com sucesso", "Pedidos obtidos com sucesso", result);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ServiceResponse(ResponseType.ERROR, "Erro ao obter pedidos", e.getMessage(), result);
		}
		
	}
}
