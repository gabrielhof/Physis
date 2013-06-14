package br.feevale.physis.enums;

import javax.servlet.http.HttpServletRequest;

import br.feevale.physis.request.RequestMethodValidator;
import br.feevale.physis.request.method.GetValidator;
import br.feevale.physis.request.method.PostValidator;

public enum RequestMethod {
	
	GET(new GetValidator()),
	POST(new PostValidator());

	private RequestMethodValidator validator;
	
	private RequestMethod(RequestMethodValidator validator) {
		this.validator = validator;
	}
	
	public boolean isValid(HttpServletRequest request) {
		return validator.isValid(request);
	}
	
}
