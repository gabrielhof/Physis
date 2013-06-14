package br.feevale.physis.factory.controller.builder;

import javax.servlet.http.HttpServletRequest;

import br.feevale.physis.builder.controller.ActionControllerBuilder;
import br.feevale.physis.builder.controller.SimpleActionControllerBuilder;

public class ActionControllerBuilderFactoryImpl implements ActionControllerBuilderFactory {

	@Override
	public ActionControllerBuilder create(HttpServletRequest request) {
		return new SimpleActionControllerBuilder(request);
	}

}
