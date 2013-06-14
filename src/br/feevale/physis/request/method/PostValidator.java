package br.feevale.physis.request.method;

import javax.servlet.http.HttpServletRequest;

import br.feevale.physis.request.RequestMethodValidator;

public class PostValidator implements RequestMethodValidator {

	@Override
	public boolean isValid(HttpServletRequest request) {
		return "POST".equalsIgnoreCase(request.getMethod());
	}

}
