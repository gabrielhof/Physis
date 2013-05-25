package br.feevale.physis.business.model.bean.moedas;

import br.feevale.physis.business.model.enums.Moedas;

public class Euro extends AbstractMoeda {

	@Override
	protected void initializeCotacoes() {
		cotacoes.put(Moedas.DOLAR, 1.29);
		cotacoes.put(Moedas.REAL, 2.62);
	}

}
