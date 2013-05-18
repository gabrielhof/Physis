package br.feevale.physis.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SeilaController implements DefaultController {

	@Override
	public void indexAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.getWriter().println("Teste\n\n");
	}
	
	public void fazAlgoAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher("/indexx.jsp");
		rd.forward(request, response);
	}

}
