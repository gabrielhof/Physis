package br.feevale.physis.exception;

public class InvalidResourceInjectorFactoryException extends RuntimeException {

	private static final long serialVersionUID = 8135810929813304433L;
	
	public InvalidResourceInjectorFactoryException(String factory, Throwable cause) {
		super(factory, cause);
	}

}
