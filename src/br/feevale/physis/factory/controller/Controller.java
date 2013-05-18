package br.feevale.physis.factory.controller;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.controller.DefaultController;
import br.feevale.physis.exception.ActionNotFoundException;
import br.feevale.physis.exception.ControllerNotFoundException;
import br.feevale.physis.util.StringUtils;


public class Controller {

	private static String CONTROLLER_PACKAGE = "org.teste.controller.";
	private static String CONTROLLER_SUFFIX = "Controller";
	private static String ACTION_SUFFIX = "Action";
	
	private Class<?> controllerClass;
	private DefaultController controller;
	
	private Map<String, Method> actions;
	
	public Controller(String controller) throws ControllerNotFoundException {
		if (StringUtils.isBlank(controller)) {
			throw new ControllerNotFoundException("Controller null or blank");
		}
		
		controller = CONTROLLER_PACKAGE + StringUtils.capitalizeFirst(controller);
		
		try {
			try {
				this.controllerClass = Class.forName(controller + CONTROLLER_SUFFIX);
			} catch (Exception e) {
				this.controllerClass = Class.forName(controller);
			}
			
			this.controller = (DefaultController) controllerClass.newInstance();
			
			this.actions = new HashMap<String, Method>();
		} catch (Exception e) {
			throw new ControllerNotFoundException(controller, e);
		}
	}
	
	public void invoke(String action, HttpServletRequest request, HttpServletResponse response) throws ActionNotFoundException {
		if (StringUtils.isBlank(action)) {
			throw new ActionNotFoundException("Action null or blank.");
		}
		
		try {
			action = StringUtils.uncapitalizeFirst(action);
			
			if (!actions.containsKey(action)) {
				Method method = null;
				
				try {
					method = controllerClass.getDeclaredMethod(action + ACTION_SUFFIX, HttpServletRequest.class, HttpServletResponse.class);
				} catch (Exception e) {
					method = controllerClass.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
				}
				
				actions.put(action, method);
			}
			
			actions.get(action).invoke(controller, request, response);
		} catch (Exception e) {
			throw new ActionNotFoundException(action, e);
		}
	}
	
}
