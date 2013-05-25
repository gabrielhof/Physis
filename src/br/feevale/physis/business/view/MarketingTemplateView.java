package br.feevale.physis.business.view;

import br.feevale.physis.exception.InvalidViewException;
import br.feevale.physis.view.TemplateView;

public class MarketingTemplateView extends TemplateView {

	public static final String TEMPLATE = "/template/marketingTemplate.jsp";
	
	public MarketingTemplateView(String controller, String view) throws InvalidViewException {
		super(controller, view);
	}
	
	@Override
	protected String getTemplate() {
		return TEMPLATE;
	}

}
