package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.driveme.business.TipoUsuarioBusiness;
import br.com.driveme.entity.TipoUsuario;


@Controller
public class HomeController {
	
	@Autowired
	TipoUsuarioBusiness tub;

	@RequestMapping(value="/")
	public ModelAndView hello() {
		
		System.out.println(this.getClass().getName());
		
		
		ModelAndView ret = new ModelAndView("index");
		
		TipoUsuario tu = new TipoUsuario();
		tu.setTiusDescricao("Administrador");
		tub.save(tu);
		
		return ret;
		
	}
}
