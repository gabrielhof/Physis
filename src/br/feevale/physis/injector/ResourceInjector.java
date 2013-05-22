package br.feevale.physis.injector;

import java.lang.reflect.Field;

public interface ResourceInjector {
	
	public void inject(Object instance, Field fieldToInject);

}
