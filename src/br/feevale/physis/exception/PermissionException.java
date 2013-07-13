package br.feevale.physis.exception;

public class PermissionException extends RuntimeException {

	private static final long serialVersionUID = 749245632701792542L;
	
	public PermissionException(String message) {
		super(message);
	}

}
