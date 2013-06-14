package br.feevale.physis.request.type;

import javax.servlet.http.HttpServletRequest;

import br.feevale.physis.request.RequestTypeValidator;

public class AnyTypeValidator implements RequestTypeValidator {

	@Override
	public boolean isValid(HttpServletRequest request) {
		return true;
	}

}
