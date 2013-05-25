package br.feevale.physis.business.model.bean.moedas;

import br.feevale.physis.business.model.enums.Moedas;


public class Real extends AbstractMoeda {

	@Override
	protected void initializeCotacoes() {
		cotacoes.put(Moedas.DOLAR, 0.49);
		cotacoes.put(Moedas.EURO, 0.38);
	}

}