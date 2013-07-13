package br.feevale.physis.business.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.feevale.physis.business.model.bean.User;
import br.feevale.physis.settings.ApplicationSettings;

public class UserSession {

	private static final ApplicationSettings settings = ApplicationSettings.getInstance();
	
	public static User getUser(HttpServletRequest request) {
		return getUser(request.getSession());
	}
	
	public static User getUser(HttpSession session) {
		return (User) session.getAttribute(settings.getSessionVariable());
	}
	
	public static void setUser(HttpServletRequest request, User user) {
		setUser(request.getSession(), user);
	}
	
	public static void setUser(HttpSession session, User user) {
		if (user != null) {
			session.setAttribute(settings.getSessionVariable(), user);
		}
	}
	
	public static void destroy(HttpSession session) {
		if (getUser(session) != null) {
			session.invalidate();
		}
	}
	
	
}
