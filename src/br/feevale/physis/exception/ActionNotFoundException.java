package br.feevale.physis.exception;

public class ActionNotFoundException extends Exception {

	private static final long serialVersionUID = 883343390857406352L;
	
	public ActionNotFoundException(String controller, String action) {
		this(controller, action, null);
	}
	
	public ActionNotFoundException(String controller, String action, Throwable cause) {
		super(String.format("Controller: %s - Action: %s", controller, action), cause);
	}

}
