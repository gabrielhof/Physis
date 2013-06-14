package br.feevale.physis.exception;

public class InvalidSessionValidatorException extends RuntimeException {

	private static final long serialVersionUID = 6516427996218728649L;
	
	public InvalidSessionValidatorException(String validator, Throwable cause) {
		super(validator, cause);
	}

}
