package br.feevale.physis.model.moedas;

import br.feevale.physis.enums.Moedas;

public class Euro extends AbstractMoeda {

	@Override
	protected void initializeCotacoes() {
		cotacoes.put(Moedas.DOLAR, 1.29);
		cotacoes.put(Moedas.REAL, 2.62);
	}

}
