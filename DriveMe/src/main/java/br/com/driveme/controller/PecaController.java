package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.driveme.business.PecaBusiness;
import br.com.driveme.util.ServiceResponse;

@RestController
@Transactional
@CrossOrigin(origins = "*")
public class PecaController {
	
	@Autowired
	PecaBusiness business;
	
	@GetMapping(value = {"/pecas"})
	public ServiceResponse getPecas() {
		return business.list();
	}
	


}
