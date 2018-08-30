package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.driveme.business.MontadoraBusiness;
import br.com.driveme.entity.Montadora;

@Controller
@Transactional
public class MontadoraController {

	@Autowired
	MontadoraBusiness tub;

	@RequestMapping(value="/montadora")
	public ModelAndView hello() {
		
		
		ModelAndView ret = new ModelAndView("index");
		
		Montadora t = new Montadora();
		
		System.out.println("SAVE");
		t.setMontDescricao("Fiat");
		tub.save(t);
		
		System.out.println("UPDATE");
		System.out.println(t.getMontDescricao());
		t.setMontDescricao("Volkswagen");
		tub.update(t);
		
		System.out.println("FIND");
		t = tub.findById(new Long(1));
		System.out.println("Descricao: " + t.getMontDescricao());
		
//		System.out.println("DELETE");
//		tub.delete(t);
		
		System.out.println("========================================");
		
		return ret;
		
	}
}
