package br.feevale.physis.exception;

public class InvalidActionControllerBuilderFactoryException extends RuntimeException  {

	private static final long serialVersionUID = 8653251780562301240L;
	
	public InvalidActionControllerBuilderFactoryException(String factory, Throwable cause) {
		super(factory, cause);
	}

}
