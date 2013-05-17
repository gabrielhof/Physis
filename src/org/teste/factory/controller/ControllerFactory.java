package org.teste.factory.controller;

import org.teste.exception.ControllerNotFoundException;

public interface ControllerFactory {
	
	public Controller create(String controller) throws ControllerNotFoundException;

}
