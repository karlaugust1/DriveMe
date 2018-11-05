package br.com.driveme.sorts;

import java.util.Comparator;

import br.com.driveme.entity.Peca;

public class SortByStars implements Comparator<Peca>{

	@Override
	public int compare(Peca peca, Peca peca1) {
		return peca1.getEstrelas() - peca.getEstrelas();
	}

}
