package org.teste.model.moedas;

import org.teste.enums.Moedas;

public class Euro extends AbstractMoeda {

	@Override
	protected void initializeCotacoes() {
		cotacoes.put(Moedas.DOLAR, 1.29);
		cotacoes.put(Moedas.REAL, 2.62);
	}

}
