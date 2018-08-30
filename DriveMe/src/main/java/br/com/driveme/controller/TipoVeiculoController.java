package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.driveme.business.TipoVeiculoBusiness;
import br.com.driveme.entity.TipoVeiculo;

@Controller
@Transactional
public class TipoVeiculoController {

	@Autowired
	TipoVeiculoBusiness tub;

	@RequestMapping(value="/tipoveiculo")
	public ModelAndView hello() {
		
		
		ModelAndView ret = new ModelAndView("index");
		
		TipoVeiculo t = new TipoVeiculo();
		
		System.out.println("SAVE");
		t.setTiveDescricao("Pesado");
		tub.save(t);
		
		System.out.println("UPDATE");
		System.out.println(t.getTiveDescricao());
		t.setTiveDescricao("Ultraleve");
		tub.update(t);
		
		System.out.println("FIND");
		t = tub.findById(new Long(1));
		System.out.println("Descricao: " + t.getTiveDescricao());
		
//		System.out.println("DELETE");
//		tub.delete(t);
		
		System.out.println("========================================");
		
		return ret;
		
	}
}
