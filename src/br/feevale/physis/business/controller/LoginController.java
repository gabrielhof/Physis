package br.feevale.physis.business.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.annotation.Request;
import br.feevale.physis.business.model.bean.User;
import br.feevale.physis.business.model.dao.UserDAO;
import br.feevale.physis.business.session.UserSession;
import br.feevale.physis.business.view.MarketingTemplateView;
import br.feevale.physis.controller.DefaultController;
import br.feevale.physis.util.ResponseUtils;
import br.feevale.physis.view.View;

public class LoginController implements DefaultController {

	@Resource
	private UserDAO userDAO;
	
	@Override
	@Request(sessionRequired=false)
	public void indexAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean invalidLogin = (boolean) request.getSession().getAttribute("invalidLogin");
		request.getSession().removeAttribute("invalidLogin");
		
		View view = new MarketingTemplateView("login", "login");
		view.setVariable("useLoginBar", false);
		view.setVariable("invalidLogin", invalidLogin);
		view.forward(request, response);
	}
	
	@Request(sessionRequired=false)
	public void doLoginAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = userDAO.get(request.getParameter("username"), request.getParameter("password"));
		
		if (user == null) {
			request.getSession().setAttribute("invalidLogin", true);
			ResponseUtils.redirect(request, response, "login");
		} else {
			UserSession.setUser(request, user);
			ResponseUtils.redirect(request, response, "home");
		}
	}
}
