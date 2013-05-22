package br.feevale.physis.factory.injector;

import br.feevale.physis.injector.ResourceInjector;

public interface ResourceInjectorFactory {

	public ResourceInjector getInjector(Class<?> type);
	
}
