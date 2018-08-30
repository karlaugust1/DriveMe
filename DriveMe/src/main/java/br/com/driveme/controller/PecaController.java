package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.driveme.business.PecaBusiness;
import br.com.driveme.entity.Peca;

@Controller
@Transactional
public class PecaController {

	@Autowired
	PecaBusiness tub;

	@RequestMapping(value="/peca")
	public ModelAndView hello() {
		
		
		ModelAndView ret = new ModelAndView("index");
		
		Peca t = new Peca();
		
		System.out.println("SAVE");
		t.setPecaDescricao("Peca");
		t.setPecaIdOriginal("IdOriginalPodeSerQualquerCoisa");
		t.setPecaValor(new Double(66));
		//tub.save(t);
		
		System.out.println("FIND");
		t = tub.findById(new Long(1));
		System.out.println("Descricao: " + t.getPecaDescricao());
		
		System.out.println("UPDATE");
		System.out.println(t.getPecaDescricao());
		t.setPecaDescricao("Peca modificada");
		tub.update(t);
		
		
//		System.out.println("DELETE");
//		tub.delete(t);
		
		System.out.println("========================================");
		
		return ret;
		
	}
	
}
