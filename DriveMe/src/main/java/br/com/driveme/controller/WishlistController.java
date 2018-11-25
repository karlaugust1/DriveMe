package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.driveme.business.WishlistBusiness;
import br.com.driveme.entity.Wishlist;
import br.com.driveme.util.ServiceResponse;

@RestController
@Transactional
@CrossOrigin(origins = "*")
public class WishlistController {
	
	@Autowired
	WishlistBusiness business;
	
	@PostMapping(value = {"wishlist/adicionar"})
	public ServiceResponse addPeca(@RequestBody Wishlist wishlist) {
		return business.adicionarPeca(wishlist);
	}
	
	@PostMapping(value = {"wishlist/remover"})
	public ServiceResponse removePeca(@RequestBody Wishlist wishlist) {
		return business.removerPeca(wishlist);
	}
	
	@GetMapping(value = {"wishlist/{idUsuario}"})
	public ServiceResponse getWishlist(@PathVariable (name = "idUsuario", required = false) Long idUsuario) {
		return business.listByUsuarioId(idUsuario);
	}

}
