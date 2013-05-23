package br.feevale.physis.exception;

public class InvalidViewException extends Exception {

	private static final long serialVersionUID = 7432155783150747093L;

	public InvalidViewException(String controller, String view) {
		super("Controller: " + controller + " - View: " + view);
	}

}
