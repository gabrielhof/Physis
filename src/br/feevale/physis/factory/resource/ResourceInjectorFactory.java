package br.feevale.physis.factory.resource;

import br.feevale.physis.injector.ResourceInjector;

public interface ResourceInjectorFactory {

	public ResourceInjector getInjector(Class<?> type);
	
}
