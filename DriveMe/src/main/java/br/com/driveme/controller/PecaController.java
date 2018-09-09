package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.driveme.business.PecaBusiness;
import br.com.driveme.entity.MontadoraTipoVeiculo;
import br.com.driveme.entity.Peca;
import br.com.driveme.entity.PecaModelo;

@RestController
@Transactional
public class PecaController {

	@Autowired
	PecaBusiness tub;

	@GetMapping("/peca")
	public Peca hello() {
		
		
	//	ModelAndView ret = new ModelAndView("index");
		
		Peca t = new Peca();
		
		//System.out.println("SAVE");
		//t.setPecaDescricao("Peca");
		//t.setPecaIdOriginal("IdOriginalPodeSerQualquerCoisa");
	//	t.setPecaValor(new Double(66));
		//tub.save(t);
		
		System.out.println("FIND");
		t = tub.findById(new Long(1));
		System.out.println("ID: " + t.getPecaId());
		System.out.println("ID Original: " + t.getPecaIdOriginal());
		System.out.println("Descricao: " + t.getPecaDescricao());
		System.out.println("Visualizaçoes: " + t.getPecaVisualizacao());
		System.out.println("Valor: " + t.getPecaValor());
		System.out.println("Descricao: " + t.getPecaDescricao());
		System.out.println("=================================");
		for(PecaModelo pm : t.getPecaModelos()) {
			System.out.println("ID Modelo: " + pm.getModelo().getModeId());
			System.out.println("Modelo descricao: " + pm.getModelo().getModeDescricao());
			System.out.println("Modelo ano: " + pm.getModelo().getModeAno());
			System.out.println("=================================");
			System.out.println("Montadora ID: " + pm.getModelo().getMontadora().getMontId());
			System.out.println("Montadora descricao: " + pm.getModelo().getMontadora().getMontDescricao());
			for(MontadoraTipoVeiculo tv : pm.getModelo().getMontadora().getMontadoraTipoVeiculos()) {
				System.out.println("=================================");
				System.out.println("Tipo Veiculo ID: "+tv.getTipoVeiculo().getTiveId());
				System.out.println("Tipo Veiculo descricao: "+tv.getTipoVeiculo().getTiveDescricao());
			}

		}




		
	/*	System.out.println("UPDATE");
		System.out.println(t.getPecaDescricao());
		t.setPecaDescricao("Peca modificada");
		tub.update(t);*/
		
		
//		System.out.println("DELETE");
//		tub.delete(t);
		
		System.out.println("========================================");
		return tub.findById(new Long(1));
		
		
	}
	
}
