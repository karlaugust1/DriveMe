package br.com.driveme.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.Peca;
import br.com.driveme.entity.PecaPedido;
import br.com.driveme.entity.Pedido;
import br.com.driveme.entity.Wishlist;
import br.com.driveme.util.ResponseType;
import br.com.driveme.util.ServiceResponse;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class WishlistBusiness {
	
	@Autowired
	GenericDao<Wishlist> dao;	

	public ServiceResponse adicionarPeca(Wishlist wishlist) {

		Map<String, Object> result = new HashMap<>();

		try {
			
			if(wishlist.getPeca() == null || wishlist.getPeca().getPecaId() == null) {
				return new ServiceResponse(ResponseType.VALIDATION, "Peca não enviada",
						"Peca não enviada", result);
			}
			
			if(wishlist.getUsuario() == null || wishlist.getUsuario().getUsuaId() == null) {
				return new ServiceResponse(ResponseType.VALIDATION, "Usuário não enviado",
						"Usuário não enviado", result);
			}

			wishlist.setWishId(dao.save(wishlist));

			result.put("wishlist", wishlist);
			return new ServiceResponse(ResponseType.SUCCESS, "Peca adicionada com sucesso",
					"Peca adicionada com sucesso", result);

		} catch (Exception e) {
			return new ServiceResponse(ResponseType.ERROR, "Erro ao adicionar peça ao carrinho", e.getMessage(),
					result);
		}
	}

	public ServiceResponse removerPeca(Wishlist wishlist) {

		Map<String, Object> result = new HashMap<>();

		try {

			dao.delete(wishlist);

			result.put("wishlist", wishlist);
			return new ServiceResponse(ResponseType.SUCCESS, "Peca removida com sucesso", "Peca removida com sucesso",
					result);

		} catch (Exception e) {
			return new ServiceResponse(ResponseType.ERROR, "Erro ao removida peça do carrinho", e.getMessage(), result);
		}

	}
	
	public ServiceResponse listByUsuarioId(Long idUsuario) {
		
		Map<String, Object> result = new HashMap<>();
		
		try {		
			
			if(idUsuario == null) {
				return new ServiceResponse(ResponseType.SUCCESS, "Usuário não enviado", "Usuário não enviado", result);
			}
						
			List<Wishlist> wishlists = dao.list();
			List<Wishlist> wishlist = new ArrayList<>();
			
			for(int i = 0; i < wishlists.size(); i++) {
				if(wishlists.get(i).getUsuario().getUsuaId() == idUsuario) {
					wishlist.add(wishlists.get(i));
				}
			}
			
			result.put("wishlist", wishlist);
			return new ServiceResponse(ResponseType.SUCCESS, "Wishlist obtida com sucesso", "Wishlist obtida com sucesso", result);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ServiceResponse(ResponseType.ERROR, "Erro ao obter pedido", e.getMessage(), result);
		}
		
	}

}
