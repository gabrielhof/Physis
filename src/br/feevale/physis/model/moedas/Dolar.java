package br.feevale.physis.model.moedas;

import br.feevale.physis.enums.Moedas;

public class Dolar extends AbstractMoeda {

	@Override
	protected void initializeCotacoes() {
		cotacoes.put(Moedas.REAL, 2.02);
		cotacoes.put(Moedas.EURO, 0.77);
	}

}
