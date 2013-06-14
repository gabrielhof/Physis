package br.feevale.physis.enums;

import javax.servlet.http.HttpServletRequest;

import br.feevale.physis.request.RequestTypeValidator;
import br.feevale.physis.request.type.AjaxTypeValidator;
import br.feevale.physis.request.type.AnyTypeValidator;
import br.feevale.physis.request.type.HttpTypeValidator;

public enum RequestType {

	ANY(new AnyTypeValidator()),
	HTTP(new HttpTypeValidator()),
	AJAX(new AjaxTypeValidator());
	
	private RequestTypeValidator validator;
	
	private RequestType(RequestTypeValidator validator) {
		this.validator = validator;
	}
	
	public boolean isValid(HttpServletRequest request) {
		return validator.isValid(request);
	}
	
}
