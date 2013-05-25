package br.feevale.physis.settings;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import br.feevale.physis.exception.InvalidConnectionFactoryException;
import br.feevale.physis.exception.InvalidControllerFactoryException;
import br.feevale.physis.exception.InvalidResourceInjectorFactoryException;
import br.feevale.physis.factory.connection.ConnectionFactory;
import br.feevale.physis.factory.controller.ControllerFactory;
import br.feevale.physis.factory.injector.ResourceInjectorFactory;
import br.feevale.physis.util.StringUtils;

public class ApplicationSettings {

	private static ApplicationSettings INSTANCE;
	
	private String controllerPackage = ApplicationConstants.DEFAULT_CONTROLLER_PACKAGE;
	private String controllerSuffix = ApplicationConstants.DEFAULT_CONTROLLER_SUFFIX;
	private String actionSuffix = ApplicationConstants.DEFAULT_ACTION_SUFFIX;
	
	private String viewFolder = ApplicationConstants.DEFAULT_VIEW_FOLDER;
	private String viewSuffix = ApplicationConstants.DEFAULT_VIEW_SUFFIX;
	
	private String templateViewFile = ApplicationConstants.DEFAULT_TEMPLATE_VIEW_FILE;
	
	private Class<? extends ControllerFactory> controllerFactoryClass = ApplicationConstants.DEFAULT_CONTROLLER_FACTORY;
	private Class<? extends ConnectionFactory> connectionFactoryClass = ApplicationConstants.DEFAULT_CONNECTION_FACTORY;
	private Class<? extends ResourceInjectorFactory> resourceInjectorFactoryClass = ApplicationConstants.DEFAULT_RESOURCE_INJECTOR_FACTORY;
	
	public String getControllerPackage() {
		return controllerPackage;
	}

	protected void setControllerPackage(String controllerPackage) {
		if (StringUtils.isNotBlank(controllerPackage)) {
			this.controllerPackage = controllerPackage.replaceFirst("\\.$", "");
		}
	}

	public String getControllerSuffix() {
		return controllerSuffix;
	}

	protected void setControllerSuffix(String controllerSuffix) {
		if (StringUtils.isNotBlank(controllerSuffix)) {
			this.controllerSuffix = controllerSuffix;
		}
	}

	public String getActionSuffix() {
		return actionSuffix;
	}

	protected void setActionSuffix(String actionSuffix) {
		if (StringUtils.isNotBlank(actionSuffix)) {
			this.actionSuffix = actionSuffix;
		}
	}

	public String getViewFolder() {
		return viewFolder;
	}

	protected void setViewFolder(String viewFolder) {
		if (StringUtils.isNotBlank(viewFolder)) {
			this.viewFolder = viewFolder.replaceFirst("(\\|/)$", "");
		}
	}

	public String getViewSuffix() {
		return viewSuffix;
	}

	protected void setViewSuffix(String viewSuffix) {
		if (StringUtils.isNotBlank(viewSuffix)) {
			this.viewSuffix = viewSuffix;
		}
	}

	public String getTemplateViewFile() {
		return templateViewFile;
	}

	protected void setTemplateViewFile(String templateViewFile) {
		if (StringUtils.isNotBlank(templateViewFile)) {
			this.templateViewFile = templateViewFile;
		}
	}

	public Class<? extends ResourceInjectorFactory> getResourceInjectorFactoryClass() {
		return resourceInjectorFactoryClass;
	}
	
	public ResourceInjectorFactory getResourceInjectorFactory() {
		try {
			return resourceInjectorFactoryClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new InvalidResourceInjectorFactoryException(String.format("%s needs to be a POJO.", controllerFactoryClass.getName()), e);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void setResourceInjectorClass(String resourceInjectorFactoryClass) {
		if (StringUtils.isNotBlank(resourceInjectorFactoryClass)) {
			try {
				this.resourceInjectorFactoryClass = (Class<? extends ResourceInjectorFactory>) Class.forName(resourceInjectorFactoryClass);
			} catch (ClassNotFoundException e) {
				throw new InvalidResourceInjectorFactoryException(resourceInjectorFactoryClass, e);
			}
		}
	}
	
	public Class<? extends ControllerFactory> getControllerFactoryClass() {
		return controllerFactoryClass;
	}
	
	public ControllerFactory getControllerFactory() {
		try {
			return controllerFactoryClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new InvalidControllerFactoryException(String.format("%s needs to be a POJO.", controllerFactoryClass.getName()), e);
		}
	}

	@SuppressWarnings("unchecked")
	protected void setControllerFactoryClass(String controllerFactoryClass) {
		if (StringUtils.isNotBlank(controllerFactoryClass)) {
			try {
				this.controllerFactoryClass = (Class<? extends ControllerFactory>) Class.forName(controllerFactoryClass);
			} catch (ClassNotFoundException e) {
				throw new InvalidControllerFactoryException(controllerFactoryClass, e);
			}
		}
	}

	public Class<? extends ConnectionFactory> getConnectionFactoryClass() {
		return connectionFactoryClass;
	}
	
	public ConnectionFactory getConnectionFactory() {
		try {
			return connectionFactoryClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new InvalidConnectionFactoryException(String.format("%s needs to be a POJO.", connectionFactoryClass.getName()), e);
		}
	}

	@SuppressWarnings("unchecked")
	protected void setConnectionFactoryClass(String connectionFactoryClass) {
		if (StringUtils.isNotBlank(connectionFactoryClass)) {
			try {
				this.connectionFactoryClass = (Class<? extends ConnectionFactory>) Class.forName(connectionFactoryClass);
			} catch (ClassNotFoundException e) {
				throw new InvalidConnectionFactoryException(connectionFactoryClass, e);
			}
		}
	}

	public void setSettings(ServletConfig config) {
		ServletContext context = config.getServletContext();
		
		setControllerPackage(context.getInitParameter("controllerPackage"));
		setControllerSuffix(context.getInitParameter("controllerSuffix"));
		setActionSuffix(context.getInitParameter("actionSuffix"));
		
		setViewFolder(context.getInitParameter("viewFolder"));
		setViewSuffix(context.getInitParameter("viewSuffix"));
		
		setTemplateViewFile(context.getInitParameter("templateViewFile"));
		
		setControllerFactoryClass(context.getInitParameter("controllerFactoryClass"));
		setConnectionFactoryClass(context.getInitParameter("connectionFactoryClass"));
		setResourceInjectorClass(context.getInitParameter("resourceInjectorFactoryClass"));
	}
	
	public static ApplicationSettings getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ApplicationSettings();
		}
		
		return INSTANCE;
	}
	
}
