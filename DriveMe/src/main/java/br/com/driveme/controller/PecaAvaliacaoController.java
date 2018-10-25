package br.com.driveme.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.driveme.business.PecaAvaliacaoBusiness;
import br.com.driveme.entity.PecaAvaliacao;
import br.com.driveme.util.ServiceResponse;

@RestController
@Transactional
@CrossOrigin(origins = "*")
public class PecaAvaliacaoController {
	
	@Autowired
	PecaAvaliacaoBusiness business;
	
	@PostMapping(value = {"avaliacao"})
	public ServiceResponse postPecaAvaliacao(@RequestBody PecaAvaliacao pecaAvaliacao) {
		return business.save(pecaAvaliacao);
	}

}
