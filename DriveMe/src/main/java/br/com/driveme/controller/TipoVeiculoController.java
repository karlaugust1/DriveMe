package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.driveme.business.TipoVeiculoBusiness;
import br.com.driveme.entity.TipoVeiculo;
import br.com.driveme.util.ServiceResponse;

@RestController
@Transactional
@CrossOrigin(origins = "*")
public class TipoVeiculoController {
	
	@Autowired
	TipoVeiculoBusiness business;
	
	@GetMapping(value = {"/tipoveiculos"})
	public ServiceResponse getTipoVeiculos() {
		return business.list();
	}
	
	@PostMapping(value = {"/tipoveiculos"})
	public ServiceResponse postTipoVeiculo(@RequestBody TipoVeiculo tv) {
		return business.save(tv);
	}

}
