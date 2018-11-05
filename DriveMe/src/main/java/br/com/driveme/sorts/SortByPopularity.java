package br.com.driveme.sorts;

import java.util.Comparator;

import br.com.driveme.entity.Peca;

public class SortByPopularity implements Comparator<Peca> {

	@Override
	public int compare(Peca peca1, Peca peca2) {
		return peca2.getPecaVisualizacao() - peca1.getPecaVisualizacao();
	}

}
