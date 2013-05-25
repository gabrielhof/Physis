package br.feevale.physis.settings;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import br.feevale.physis.util.StringUtils;

public class ApplicationSettings {

	private static ApplicationSettings INSTANCE;
	
	private String controllerPackage = ApplicationConstants.DEFAULT_CONTROLLER_PACKAGE;
	private String controllerSuffix = ApplicationConstants.DEFAULT_CONTROLLER_SUFFIX;
	private String actionSuffix = ApplicationConstants.DEFAULT_ACTION_SUFFIX;
	
	public String getControllerPackage() {
		return controllerPackage;
	}

	public void setControllerPackage(String controllerPackage) {
		if (StringUtils.isNotBlank(controllerPackage)) {
			this.controllerPackage = controllerPackage.replaceAll("\\.$", "");
		}
	}

	public String getControllerSuffix() {
		return controllerSuffix;
	}

	public void setControllerSuffix(String controllerSuffix) {
		if (StringUtils.isNotBlank(controllerSuffix)) {
			this.controllerSuffix = controllerSuffix;
		}
	}

	public String getActionSuffix() {
		return actionSuffix;
	}

	public void setActionSuffix(String actionSuffix) {
		if (StringUtils.isNotBlank(actionSuffix)) {
			this.actionSuffix = actionSuffix;
		}
	}

	public void setSettings(ServletConfig config) {
		ServletContext context = config.getServletContext();
		
		setControllerPackage(context.getInitParameter("controllerPackage"));
		setControllerSuffix(context.getInitParameter("controllerSuffix"));
		setActionSuffix(context.getInitParameter("actionSuffix"));
		
	}
	
	public static ApplicationSettings getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ApplicationSettings();
		}
		
		return INSTANCE;
	}
	
}
