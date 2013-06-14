package br.feevale.physis.business.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.annotation.Request;
import br.feevale.physis.business.view.MarketingTemplateView;
import br.feevale.physis.controller.DefaultController;
import br.feevale.physis.view.View;

public class IndexController implements DefaultController {

	@Override
	@Request(sessionRequired=false)
	public void indexAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		View view = new MarketingTemplateView("index", "index");
		view.forward(request, response);
	}
	
}
