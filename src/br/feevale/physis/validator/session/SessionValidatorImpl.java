package br.feevale.physis.validator.session;

import javax.servlet.http.HttpServletRequest;

import br.feevale.physis.settings.ApplicationSettings;

public class SessionValidatorImpl implements SessionValidator {

	private static ApplicationSettings settings = ApplicationSettings.getInstance();
	
	@Override
	public boolean isValid(HttpServletRequest request) {
		return request.getSession().getAttribute(settings.getSessionVariable()) != null;
	}

}
