package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.driveme.business.TipoVeiculoBusiness;
import br.com.driveme.entity.TipoVeiculo;


@Controller
public class HomeController {
	
	@Autowired
	TipoVeiculoBusiness tub;

	@RequestMapping(value="/")
	public ModelAndView hello() {
		
		System.out.println(this.getClass().getName());
		
		
		ModelAndView ret = new ModelAndView("index");
		
		TipoVeiculo tu = new TipoVeiculo();
		tu.setTiveDescricao("Leve");
		tub.save(tu);
		
		return ret;
		
	}
}
