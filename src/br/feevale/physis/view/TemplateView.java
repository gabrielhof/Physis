package br.feevale.physis.view;

import javax.servlet.http.HttpServletRequest;

import br.feevale.physis.exception.InvalidViewException;

public class TemplateView extends ResponseView {

	protected static final String TEMPLATE = "/template/template.jsp";
	
	public TemplateView(String controller, String view) throws InvalidViewException {
		super(controller, view);
	}
	
	@Override
	protected void configureDefaultVariables(HttpServletRequest request) {
		super.configureDefaultVariables(request);
		setVariable("viewFile", super.buildUrl(request));
	}
	
	@Override
	protected String buildUrl(HttpServletRequest request) {
		return TEMPLATE;
	}

}
