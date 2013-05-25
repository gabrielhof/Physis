package br.feevale.physis.exception;

public class InvalidControllerFactoryException extends RuntimeException {

	private static final long serialVersionUID = -6696868606289090510L;

	public InvalidControllerFactoryException(String factory, Throwable cause) {
		super(factory, cause);
	}
	
}
