package br.feevale.physis.factory.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.annotation.Request;
import br.feevale.physis.controller.DefaultController;
import br.feevale.physis.enums.RequestMethod;
import br.feevale.physis.enums.RequestType;
import br.feevale.physis.exception.ActionNotFoundException;
import br.feevale.physis.exception.ControllerNotFoundException;
import br.feevale.physis.exception.IllegalActionAccessException;
import br.feevale.physis.factory.injector.ResourceInjectorFactory;
import br.feevale.physis.injector.ResourceInjector;
import br.feevale.physis.settings.ApplicationSettings;
import br.feevale.physis.util.ReflectionUtils;
import br.feevale.physis.util.StringUtils;
import br.feevale.physis.validator.session.SessionValidator;


public class Controller {

	private static ApplicationSettings settings = ApplicationSettings.getInstance();
	private static final ResourceInjectorFactory injectorFactory = settings.getResourceInjectorFactory();
	private static final SessionValidator sessionValidator = settings.getSessionValidator();
	
	private Class<?> controllerClass;
	private DefaultController controller;
	
	private Map<String, Method> actions = new HashMap<String, Method>();
	
	
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
	
	public void invoke(String action, HttpServletRequest request, HttpServletResponse response) throws ActionNotFoundException, IllegalActionAccessException {
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
		
				validateAction(method, request);
				actions.put(action, method);
			}
			
			actions.get(action).invoke(controller, request, response);
		} catch (IllegalActionAccessException e) {
			throw e;
		} catch (Exception e) {
			throw new ActionNotFoundException(controllerClass.toString(), action, e);
		}
	}
	
	protected void validateAction(Method method, HttpServletRequest request) throws IllegalActionAccessException {
		boolean sessionRequired = settings.isSessionRequiredByDefault();
		
		if (method.isAnnotationPresent(Request.class)) {
			Request annotation = method.getAnnotation(Request.class);
			
			if (annotation.methods() != null) {
				RequestMethod[] methods = annotation.methods();

				boolean isValid = false;
				if (methods.length > 0) {
					for (RequestMethod requestMethod : methods) {
						if (requestMethod.isValid(request)) {
							isValid = true;
							break;
						}
					}
				} else {
					isValid = true;
				}
				
				if (!isValid) {
					throw new IllegalActionAccessException(String.format("Not available for %s method.", request.getMethod()));
				}
			}
			
			RequestType type = annotation.type() == null ? RequestType.ANY : annotation.type();
			if (!type.isValid(request)) {
				throw new IllegalActionAccessException(type.toString());
			}
			
			sessionRequired = annotation.sessionRequired();
		}
		
		boolean hasSession = sessionValidator.isValid(request);
		if (sessionRequired && !hasSession) {
			throw new IllegalActionAccessException("The session is required. Please do login.");
		} else if (!sessionRequired && hasSession) {
			throw new IllegalActionAccessException("The session is not required. Please do logoff.");
		}
	}
}
