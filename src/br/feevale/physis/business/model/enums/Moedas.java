package br.feevale.physis.business.model.enums;

import br.feevale.physis.business.model.bean.moedas.Dolar;
import br.feevale.physis.business.model.bean.moedas.Euro;
import br.feevale.physis.business.model.bean.moedas.Moeda;
import br.feevale.physis.business.model.bean.moedas.Real;

public enum Moedas {

	REAL("REAL", new Real()),
	DOLAR("DOLAR", new Dolar()),
	EURO("EURO", new Euro());
	
	private String symbol;
	private Moeda moeda;
	
	Moedas(String symbol, Moeda moeda) {
		this.symbol = symbol;
		this.moeda = moeda;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public Moeda getMoeda() {
		return moeda;
	}
	
	public static Moedas value(String symbol) {
		for (Moedas moeda : values()) {
			if (moeda.getSymbol().equalsIgnoreCase(symbol)) {
				return moeda;
			}
		}
		
		return null;
	}
	
}
