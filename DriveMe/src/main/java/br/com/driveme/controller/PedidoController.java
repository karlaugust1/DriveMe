package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.driveme.business.PedidoBusiness;
import br.com.driveme.entity.Pedido;
import br.com.driveme.entity.Usuario;

@Controller
@Transactional
public class PedidoController {
	
	@Autowired
	PedidoBusiness tub;

	@RequestMapping(value="/pedido")
	public ModelAndView hello() {
		
		
		ModelAndView ret = new ModelAndView("index");
		
		Pedido t = new Pedido();
		
		System.out.println("SAVE");
		t.setUsuario(new Usuario(1, null));
		tub.save(t);
		
		System.out.println("UPDATE");
		t.setPediTotal(new Double(100));
		System.out.println(t.getPediTotal());
		tub.update(t);
		
		System.out.println("FIND");
		t = tub.findById(new Long(1));
		System.out.println("Total: " + t.getPediTotal());
		
//		System.out.println("DELETE");
//		tub.delete(t);
		
		System.out.println("========================================");
		
		return ret;
		
	}
}
