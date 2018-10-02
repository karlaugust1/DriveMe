package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.driveme.business.AplicacaoBusiness;
import br.com.driveme.util.ServiceResponse;

@RestController
@Transactional
@CrossOrigin(origins = "*")
public class AplicacaoController {
	
	@Autowired
	AplicacaoBusiness business;
	
	@GetMapping(value = {"/aplicacoes"})
	public ServiceResponse getAplicacaoes() {
		return business.list();
	}
	


}
