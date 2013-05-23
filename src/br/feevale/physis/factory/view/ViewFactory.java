package br.feevale.physis.factory.view;

import br.feevale.physis.exception.InvalidViewException;
import br.feevale.physis.view.ResponseView;
import br.feevale.physis.view.View;

public class ViewFactory {

	public static View create(String controller, String view) throws InvalidViewException {
		return new ResponseView(controller, view);
	}
	
}
