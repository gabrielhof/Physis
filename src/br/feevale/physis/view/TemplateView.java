package br.feevale.physis.view;

import javax.servlet.http.HttpServletRequest;

import br.feevale.physis.exception.InvalidViewException;
import br.feevale.physis.settings.ApplicationSettings;

public class TemplateView extends ResponseView {

	protected ApplicationSettings settings = ApplicationSettings.getInstance();
	
	public TemplateView(String controller, String view) throws InvalidViewException {
		super(controller, view);
	}
	
	@Override
	protected void configureDefaultAttributes(HttpServletRequest request) {
		super.configureDefaultAttributes(request);
		request.setAttribute("viewFile", super.buildUrl(request));
	}
	
	@Override
	protected String buildUrl(HttpServletRequest request) {
		return getTemplate();
	}
	
	protected String getTemplate() {
		return settings.getTemplateViewFile();
	}
	
}
