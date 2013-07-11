package br.feevale.physis.business.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.annotation.Request;
import br.feevale.physis.builder.view.ViewBuilder;
import br.feevale.physis.controller.DefaultController;
import br.feevale.physis.view.View;

public class HomeController implements DefaultController {

	@Override
	@Request(sessionRequired=true)
	public void indexAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		View view = ViewBuilder.build("home", "home");
		view.forward(request, response);
	}

}
