package br.feevale.physis.request;

import javax.servlet.http.HttpServletRequest;

public interface RequestMethodValidator {

	public boolean isValid(HttpServletRequest request);
	
}
