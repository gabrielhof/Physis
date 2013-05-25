package br.feevale.physis.business.model.bean.moedas;

import br.feevale.physis.business.model.enums.Moedas;

public interface Moeda {

	public double getCotacao(Moedas destino);
	
}
