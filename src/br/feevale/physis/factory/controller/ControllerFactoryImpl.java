package br.feevale.physis.factory.controller;

import java.util.HashMap;
import java.util.Map;

import br.feevale.physis.exception.ControllerNotFoundException;

public class ControllerFactoryImpl implements ControllerFactory {

	public Map<String, Controller> controllers = new HashMap<String, Controller>();
	
	@Override
	public Controller create(String controllerName) throws ControllerNotFoundException {
		if (!controllers.containsKey(controllerName)) {
			Controller controller = new Controller(controllerName);
			controllers.put(controllerName, controller);
		}
		
		return controllers.get(controllerName);
	}

}
