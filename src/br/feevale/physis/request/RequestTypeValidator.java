package br.feevale.physis.request;

import javax.servlet.http.HttpServletRequest;

public interface RequestTypeValidator {

	public boolean isValid(HttpServletRequest request);
	
}
