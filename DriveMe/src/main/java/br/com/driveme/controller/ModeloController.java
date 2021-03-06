package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.driveme.business.ModeloBusiness;
import br.com.driveme.entity.Modelo;
import br.com.driveme.util.ServiceResponse;

@RestController
@Transactional
@CrossOrigin(origins = "*")
public class ModeloController {

	@Autowired
	ModeloBusiness business;
	
	@GetMapping(value = {"/modelos"})
	public ServiceResponse getModelos() {
		return business.list();
	}
	
	@PostMapping(value = {"/modelos"})
	public ServiceResponse postModelo(@RequestBody Modelo m) {
		return business.save(m);
	}
	
}
