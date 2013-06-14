package br.feevale.physis.validator.session;

import javax.servlet.http.HttpServletRequest;

public interface SessionValidator {

	public boolean isValid(HttpServletRequest request);
	
}
