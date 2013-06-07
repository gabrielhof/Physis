package br.feevale.physis.business.view;

import javax.servlet.http.HttpServletRequest;

import br.feevale.physis.exception.InvalidViewException;
import br.feevale.physis.view.TemplateView;

public class MarketingTemplateView extends TemplateView {

	public static final String TEMPLATE = "/template/marketingTemplate.jsp";
	
	public MarketingTemplateView(String controller, String view) throws InvalidViewException {
		super(controller, view);
	}
	
	@Override
	protected void configureDefaultAttributes(HttpServletRequest request) {
		super.configureDefaultAttributes(request);
		request.setAttribute("useLoginBar", true);
	}
	
	@Override
	protected String getTemplate() {
		return TEMPLATE;
	}

}
