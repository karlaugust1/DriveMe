package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.driveme.business.AplicacaoBusiness;
import br.com.driveme.entity.Aplicacao;


@Controller
@Transactional
public class HomeController {
	
	@Autowired
	AplicacaoBusiness tub;

	@RequestMapping(value="/aplicacao")
	public ModelAndView hello() {
		
		
		ModelAndView ret = new ModelAndView("index");
		
		Aplicacao t = new Aplicacao();
		
		System.out.println("SAVE");
		t.setApliDescricao("Suspensao");
		tub.save(t);
		
		System.out.println("UPDATE");
		System.out.println(t.getApliDescricao());
		t.setApliDescricao("Motor");
		tub.update(t);
		
		System.out.println("FIND");
		t = tub.findById(new Long(1));
		System.out.println("Descricao: " + t.getApliDescricao());
		
//		System.out.println("DELETE");
//		tub.delete(t);
		
		System.out.println("========================================");
		
		return ret;
		
	}
}
