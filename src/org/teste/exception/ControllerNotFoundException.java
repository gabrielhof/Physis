package org.teste.exception;

public class ControllerNotFoundException extends Exception {

	private static final long serialVersionUID = -8832387092828792913L;
	
	public ControllerNotFoundException(String controller) {
		super(controller);
	}
	
	public ControllerNotFoundException(String controller, Throwable cause) {
		super(controller, cause);
	}

}
