package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.driveme.business.MontadoraBusiness;
import br.com.driveme.entity.Montadora;
import br.com.driveme.util.ServiceResponse;

@RestController
@Transactional
@CrossOrigin(origins = "*")
public class MontadoraController {

	@Autowired
	MontadoraBusiness business;

	@GetMapping(value= {"/montadoras"})
	public ServiceResponse getMontadora() {
		return business.list();	
	}
	
	@PostMapping(value = {"/montadoras"})
	public ServiceResponse postMontadora(@RequestBody Montadora m) {
		return business.save(m);
	}
}
