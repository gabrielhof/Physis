package br.feevale.physis.settings;

import br.feevale.physis.factory.connection.ConnectionFactory;
import br.feevale.physis.factory.connection.DataSourceConnectionFactory;
import br.feevale.physis.factory.controller.ControllerFactory;
import br.feevale.physis.factory.controller.ControllerFactoryImpl;
import br.feevale.physis.factory.controller.builder.ActionControllerBuilderFactory;
import br.feevale.physis.factory.controller.builder.ActionControllerBuilderFactoryImpl;
import br.feevale.physis.factory.injector.ResourceInjectorFactory;
import br.feevale.physis.factory.injector.ResourceInjectorFactoryImpl;
import br.feevale.physis.validator.session.SessionValidator;
import br.feevale.physis.validator.session.SessionValidatorImpl;

public final class ApplicationConstants {

	public static final String DEFAULT_CONTROLLER_PACKAGE = "br.feevale.physis.controller";
	
	public static final String DEFAULT_CONTROLLER_SUFFIX = "Controller";
	
	public static final String DEFAULT_ACTION_SUFFIX = "Action";
	
	public static final String DEFAULT_VIEW_FOLDER = "/view";
	
	public static final String DEFAULT_VIEW_SUFFIX = "View";
	
	public static final String DEFAULT_TEMPLATE_VIEW_FILE = "/template/template.jsp";
	
	public static final String DEFAULT_SESSION_VARIABLE = "userSession";
	
	public static final String PERSISTENCE_UNIT_NAME = "physis";
	
	public static final Class<? extends ControllerFactory> DEFAULT_CONTROLLER_FACTORY = ControllerFactoryImpl.class;
	
	public static final Class<? extends ActionControllerBuilderFactory> DEFAULT_ACTION_CONTROLLER_BUILDER_FACTORY = ActionControllerBuilderFactoryImpl.class;
	
	public static final Class<? extends ConnectionFactory> DEFAULT_CONNECTION_FACTORY = DataSourceConnectionFactory.class;
	
	public static final Class<? extends ResourceInjectorFactory> DEFAULT_RESOURCE_INJECTOR_FACTORY = ResourceInjectorFactoryImpl.class;
	
	public static final Class<? extends SessionValidator> DEFAULT_SESSION_VALIDATOR = SessionValidatorImpl.class;
	
	public static final boolean SESSION_REQUIRED_BY_DEFAULT = true;
	
}
