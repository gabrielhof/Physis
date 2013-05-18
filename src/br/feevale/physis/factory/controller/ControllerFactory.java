package br.feevale.physis.factory.controller;

import br.feevale.physis.exception.ControllerNotFoundException;

public interface ControllerFactory {
	
	public Controller create(String controller) throws ControllerNotFoundException;

}
