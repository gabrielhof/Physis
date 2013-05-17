package org.teste.factory.controller;

import java.util.HashMap;
import java.util.Map;

import org.teste.exception.ControllerNotFoundException;

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
