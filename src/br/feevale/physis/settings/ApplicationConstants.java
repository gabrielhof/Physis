package br.feevale.physis.settings;

import br.feevale.physis.factory.connection.ConnectionFactory;
import br.feevale.physis.factory.connection.DataSourceConnectionFactory;
import br.feevale.physis.factory.controller.ControllerFactory;
import br.feevale.physis.factory.controller.ControllerFactoryImpl;
import br.feevale.physis.factory.injector.ResourceInjectorFactory;
import br.feevale.physis.factory.injector.ResourceInjectorFactoryImpl;

public final class ApplicationConstants {

	public static final String DEFAULT_CONTROLLER_PACKAGE = "br.feevale.physis.controller";
	
	public static final String DEFAULT_CONTROLLER_SUFFIX = "Controller";
	
	public static final String DEFAULT_ACTION_SUFFIX = "Action";
	
	public static final String DEFAULT_VIEW_FOLDER = "/view";
	
	public static final String DEFAULT_VIEW_SUFFIX = "View";
	
	public static final String DEFAULT_TEMPLATE_VIEW_FILE = "/template/template.jsp";
	
	public static final Class<? extends ControllerFactory> DEFAULT_CONTROLLER_FACTORY = ControllerFactoryImpl.class;
	
	public static final Class<? extends ConnectionFactory> DEFAULT_CONNECTION_FACTORY = DataSourceConnectionFactory.class;
	
	public static final Class<? extends ResourceInjectorFactory> DEFAULT_RESOURCE_INJECTOR_FACTORY = ResourceInjectorFactoryImpl.class;
	
}
