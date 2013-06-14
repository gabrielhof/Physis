package br.feevale.physis.builder.view;

import br.feevale.physis.exception.InvalidViewException;
import br.feevale.physis.view.TemplateView;
import br.feevale.physis.view.View;

public class ViewBuilder {

	public static View build(String controller, String view) throws InvalidViewException {
		return new TemplateView(controller, view);
	}
	
}
