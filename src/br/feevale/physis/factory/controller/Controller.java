package br.feevale.physis.factory.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.controller.DefaultController;
import br.feevale.physis.exception.ActionNotFoundException;
import br.feevale.physis.exception.ControllerNotFoundException;
import br.feevale.physis.factory.injector.ResourceInjectorFactory;
import br.feevale.physis.injector.ResourceInjector;
import br.feevale.physis.settings.ApplicationSettings;
import br.feevale.physis.util.ReflectionUtils;
import br.feevale.physis.util.StringUtils;


public class Controller {

	private static final ResourceInjectorFactory injectorFactory = ApplicationSettings.getInstance().getResourceInjectorFactory();
	
	private Class<?> controllerClass;
	private DefaultController controller;
	
	private Map<String, Method> actions = new HashMap<String, Method>();
	
	private ApplicationSettings settings = ApplicationSettings.getInstance();
	
	public Controller(String controller) throws ControllerNotFoundException {
		if (StringUtils.isBlank(controller)) {
			throw new ControllerNotFoundException("Controller null or blank");
		}
		
		controller = String.format("%s.%s", settings.getControllerPackage(), StringUtils.capitalizeFirst(controller));
		
		try {
			try {
				this.controllerClass = Class.forName(controller + settings.getControllerSuffix());
			} catch (Exception e) {
				this.controllerClass = Class.forName(controller);
			}
			
			this.controller = (DefaultController) controllerClass.newInstance();
			
			injectDependencies();
		} catch (Exception e) {
			throw new ControllerNotFoundException(controller, e);
		}
	}
	
	protected void injectDependencies() {
		Field fields[] = ReflectionUtils.getAnnotatedFields(controllerClass, Resource.class);
		
		if (fields != null) {
			for (Field field : fields) {
				ResourceInjector injector = injectorFactory.getInjector(field.getType());
				
				if (injector != null) {
					injector.inject(controller, field);
				}
			}
		}
		
	}
	
	public void invoke(String action, HttpServletRequest request, HttpServletResponse response) throws ActionNotFoundException {
		if (StringUtils.isBlank(action)) {
			throw new ActionNotFoundException(controllerClass.toString(), "Action null or blank.");
		}
		
		try {
			action = StringUtils.uncapitalizeFirst(action);
			
			if (!actions.containsKey(action)) {
				Method method = null;
				
				try {
					method = controllerClass.getDeclaredMethod(action + settings.getActionSuffix(), HttpServletRequest.class, HttpServletResponse.class);
				} catch (Exception e) {
					method = controllerClass.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
				}
				
				actions.put(action, method);
			}
			
			actions.get(action).invoke(controller, request, response);
		} catch (Exception e) {
			throw new ActionNotFoundException(controllerClass.toString(), action, e);
		}
	}
}
