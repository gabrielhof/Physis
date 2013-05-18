package br.feevale.physis.enums;

import br.feevale.physis.model.moedas.Dolar;
import br.feevale.physis.model.moedas.Euro;
import br.feevale.physis.model.moedas.Moeda;
import br.feevale.physis.model.moedas.Real;

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
