package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.driveme.business.PecaBusiness;
import br.com.driveme.entity.Peca;
import br.com.driveme.util.ServiceResponse;

@RestController
@Transactional
@CrossOrigin(origins = "*")
public class PecaController {
	
	@Autowired
	PecaBusiness business;
	
	@GetMapping(value = {"/pecas", "/pecas/{id}"})
	public ServiceResponse getPecas(@PathVariable (name = "id", required = false) Long id) {
		return business.list(id);
	}
	
	@PostMapping(value = {"pecas"})
	public ServiceResponse postPeca(@RequestBody Peca peca) {
		return business.save(peca);
	}
	
	@GetMapping(value = {"/pecas/melhores"})
	public ServiceResponse getBestProducts() {
		return business.listBestProducts();
	}
	
	@GetMapping(value = {"/pecas/populares"})
	public ServiceResponse getPopularParts() {
		return business.listPopularParts();
	}
}
