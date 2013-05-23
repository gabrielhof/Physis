package br.feevale.physis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController implements DefaultController {

	@Override
	public void indexAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.getWriter().println("TODO");
	}
	
}
