package br.com.driveme.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.driveme.business.AplicacaoBusiness;
import br.com.driveme.entity.Aplicacao;

public class AplicacaoTest {

	@Test
	public void testSaveAplicacao() {
		Aplicacao a = new Aplicacao();
		a.setApliDescricao("Suspensao");
		try {
			new AplicacaoBusiness().save(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(true, a.getApliId() != null );
	}
}
