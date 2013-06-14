package br.feevale.physis.request.method;

import javax.servlet.http.HttpServletRequest;

import br.feevale.physis.request.RequestMethodValidator;

public class GetValidator implements RequestMethodValidator {

	@Override
	public boolean isValid(HttpServletRequest request) {
		return "GET".equalsIgnoreCase(request.getMethod());
	}

}
