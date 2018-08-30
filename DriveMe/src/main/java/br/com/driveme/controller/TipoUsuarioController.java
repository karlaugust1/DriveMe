package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.driveme.business.TipoUsuarioBusiness;
import br.com.driveme.entity.TipoUsuario;

@Controller
@Transactional
public class TipoUsuarioController {

	@Autowired
	TipoUsuarioBusiness tub;

	@RequestMapping(value="/tipousuario")
	public ModelAndView hello() {
		
		
		ModelAndView ret = new ModelAndView("index");
		
		TipoUsuario t = new TipoUsuario();
		
		System.out.println("SAVE");
		t.setTiusDescricao("Administrador");
		tub.save(t);
		
		System.out.println("UPDATE");
		System.out.println(t.getTiusDescricao());
		t.setTiusDescricao("Faxineiro");
		tub.update(t);
		
		System.out.println("FIND");
		t = tub.findById(new Long(1));
		System.out.println("Descricao: " + t.getTiusDescricao());
		
//		System.out.println("DELETE");
//		tub.delete(t);
		
		System.out.println("========================================");
		
		return ret;
		
	}
	
}
