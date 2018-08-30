package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.driveme.business.UsuarioBusiness;
import br.com.driveme.entity.TipoUsuario;
import br.com.driveme.entity.Usuario;

@Controller
@Transactional
public class UsuarioController {
	
	@Autowired
	UsuarioBusiness tub;

	@RequestMapping(value="/usuario")
	public ModelAndView hello() {
		
		
		ModelAndView ret = new ModelAndView("index");
		
		Usuario t = new Usuario();
		
		System.out.println("SAVE");
		t.setUsuaNome("Karl");
		t.setTipoUsuario(new TipoUsuario(1, null));
		tub.save(t);
		
		System.out.println("UPDATE");
		System.out.println(t.getUsuaNome());
		t.setUsuaNome("Alisson");
		tub.update(t);
		
		System.out.println("FIND");
		t = tub.findById(new Long(1));
		System.out.println("Descricao: " + t.getUsuaNome());
		
//		System.out.println("DELETE");
//		tub.delete(t);
		
		System.out.println("========================================");
		
		return ret;
		
	}
}
