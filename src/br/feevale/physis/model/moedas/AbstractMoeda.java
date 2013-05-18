package br.feevale.physis.model.moedas;

import java.util.HashMap;
import java.util.Map;

import br.feevale.physis.enums.Moedas;

public abstract class AbstractMoeda implements Moeda {

	protected Map<Moedas, Double> cotacoes;
	
	@Override
	public double getCotacao(Moedas destino) {
		if (cotacoes == null) {
			cotacoes = new HashMap<Moedas, Double>();
			initializeCotacoes();
		}
		
		if (equals(destino.getMoeda())) {
			return 1D;
		} else if (cotacoes != null) {
			Double cotacao = cotacoes.get(destino);
			
			if (cotacao != null) {
				return cotacao.doubleValue();
			}
		}
		
		return 0;
	}
	
	protected abstract void initializeCotacoes();

}
