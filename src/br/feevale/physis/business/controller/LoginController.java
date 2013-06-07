package br.feevale.physis.business.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.business.model.bean.User;
import br.feevale.physis.business.model.dao.UserDAO;
import br.feevale.physis.business.view.MarketingTemplateView;
import br.feevale.physis.controller.DefaultController;
import br.feevale.physis.view.View;

public class LoginController implements DefaultController {

	@Resource
	private UserDAO userDAO;
	
	@Override
	public void indexAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		View view = new MarketingTemplateView("login", "login");
		view.setVariable("useLoginBar", false);
		view.setVariable("invalidLogin", request.getSession().getAttribute("invalidLogin"));
		view.forward(request, response);
	}
	
	public void doLoginAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = userDAO.get(request.getParameter("username"), request.getParameter("password"));
		
		if (user == null) {
			request.getSession().setAttribute("invalidLogin", user == null);
			response.sendRedirect(request.getContextPath() + request.getServletPath() + "/login");
		} else {
			//TODO redirec to home
		}
	}
}
