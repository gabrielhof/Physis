package br.feevale.physis.builder.controller;

import javax.servlet.http.HttpServletRequest;

public class SimpleActionControllerBuilder implements ActionControllerBuilder {

	private String url[];
	
	private String controller;
	private String action;
	
	public SimpleActionControllerBuilder(HttpServletRequest request) {
		url = request.getRequestURI().split("/");
		
		this.controller = buildController();
		this.action = buildAction();
	}
	
	@Override
	public String getController() {
		return controller;
	}

	@Override
	public String getAction() {
		return action;
	}
	
	protected String buildController() {
		if (url.length == 4) {
			//Caso o tamanho da url seja 4, o valor da ultima posicao da url sera o controller 
			return url[3];
		} else if (url.length > 4) {
			//Se for maior que 4, o controller sera a penultima posicao da url
			return url[url.length-2]; //
		} else {
			//Caso seja menor que 4, nao havera controller e o default sera o 'index'
			return "index";
		}
	}
	
	protected String buildAction() {
		/*
		 * Verifica se a url possui mais de 4 posicoes, a ultima posicao sera a action.
		 * Caso contrario a action sera a 'index'
		 */
		return url.length > 4 ? url[url.length-1] : "index";
	}
}
