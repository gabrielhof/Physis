package br.feevale.physis.exception;

public class ActionNotFoundException extends Exception {

	private static final long serialVersionUID = 883343390857406352L;
	
	public ActionNotFoundException(String action) {
		super(action);
	}
	
	public ActionNotFoundException(String action, Throwable cause) {
		super(action, cause);
	}

}
