package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.driveme.business.ModeloBusiness;
import br.com.driveme.entity.Modelo;
import br.com.driveme.entity.Montadora;

@Controller
@Transactional
public class ModeloController {

	@Autowired
	ModeloBusiness tub;

	@RequestMapping(value="/modelo")
	public ModelAndView hello() {
		
		
		ModelAndView ret = new ModelAndView("index");
		
		Modelo t = new Modelo();
		
		System.out.println("SAVE");
		t.setModeDescricao("Gol");
		t.setMontadora(new Montadora(new Long(1), null, null));
		tub.save(t);
		
		System.out.println("UPDATE");
		System.out.println(t.getModeDescricao());
		t.setModeDescricao("Corsa");
		tub.update(t);
		
		System.out.println("FIND");
		t = tub.findById(new Long(1));
		System.out.println("Descricao: " + t.getModeDescricao());
		
		/*System.out.println("DELETE");
		tub.delete(t);*/
		
		System.out.println("========================================");
		
		return ret;
		
	}
	
}
