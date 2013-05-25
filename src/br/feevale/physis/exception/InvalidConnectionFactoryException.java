package br.feevale.physis.exception;

import br.feevale.physis.factory.connection.ConnectionFactory;

public class InvalidConnectionFactoryException extends RuntimeException {

	private static final long serialVersionUID = -2966291379079316273L;
	
	public InvalidConnectionFactoryException(ConnectionFactory factory) {
		this(factory == null ? "Null." : factory.toString(), null);
	}
	
	public InvalidConnectionFactoryException(String factory, Throwable cause) {
		super(factory, cause);
	}

}
