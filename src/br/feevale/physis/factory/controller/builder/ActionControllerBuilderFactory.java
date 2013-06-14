package br.feevale.physis.factory.controller.builder;

import javax.servlet.http.HttpServletRequest;

import br.feevale.physis.builder.controller.ActionControllerBuilder;

public interface ActionControllerBuilderFactory {

	public ActionControllerBuilder create(HttpServletRequest request);
	
}
