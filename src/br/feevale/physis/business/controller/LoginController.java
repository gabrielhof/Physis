package br.feevale.physis.business.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.feevale.physis.annotation.Request;
import br.feevale.physis.business.model.bean.User;
import br.feevale.physis.business.model.dao.UserDAO;
import br.feevale.physis.business.session.UserSession;
import br.feevale.physis.business.view.MarketingTemplateView;
import br.feevale.physis.controller.DefaultController;
import br.feevale.physis.enums.RequestMethod;
import br.feevale.physis.util.RequestUtils;
import br.feevale.physis.view.View;

public class LoginController implements DefaultController {

	@Resource
	private UserDAO userDAO;
	
	@Override
	@Request(sessionRequired=false)
	public void indexAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		boolean invalidLogin = session.getAttribute("invalidLogin") != null && (boolean) session.getAttribute("invalidLogin");
		session.removeAttribute("invalidLogin");
		
		View view = new MarketingTemplateView("login", "login");
		view.setVariable("useLoginBar", false);
		view.setVariable("invalidLogin", invalidLogin);
		view.forward(request, response);
	}
	
	@Request(sessionRequired=false, methods={RequestMethod.POST})
	public void doLoginAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = userDAO.get(request.getParameter("username"), request.getParameter("password"));
		
		if (user == null) {
			request.getSession().setAttribute("invalidLogin", true);
			RequestUtils.redirect(request, response, "login");
		} else {
			UserSession.setUser(request, user);
			RequestUtils.redirect(request, response, "home");
		}
	}
	
	@Request(sessionRequired=true)
	public void doLogoff(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserSession.destroy(request.getSession());
		RequestUtils.redirect(request, response, "");
	}
}
