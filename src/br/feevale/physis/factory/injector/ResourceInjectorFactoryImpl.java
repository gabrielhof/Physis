package br.feevale.physis.factory.injector;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.feevale.physis.dao.GenericDAO;
import br.feevale.physis.injector.DAOInjector;
import br.feevale.physis.injector.ResourceInjector;
import br.feevale.physis.util.CollectionUtils;

public class ResourceInjectorFactoryImpl implements ResourceInjectorFactory {

	public Map<Class<?>, ResourceInjector> injectors = new HashMap<Class<?>, ResourceInjector>();
	
	public ResourceInjectorFactoryImpl() {
		configureInjectors();
	}
	
	@Override
	public ResourceInjector getInjector(Class<?> type) {
		if (type == null) {
			return null;
		}
		
		if (!injectors.containsKey(type)) {
			if (Object.class.equals(type)) {
				return null;
			} else {
				ResourceInjector ri = null;
				
				List<Class<?>> interfaces = Arrays.asList(type.getInterfaces());
				if (CollectionUtils.isNotEmpty(interfaces)) {
					for (Class<?> clazz : interfaces) {
						ri = getInjector(clazz);
						if (ri != null) {
							break;
						}
					}
				}
				
				if (ri == null) {
					ri = getInjector(type.getSuperclass());
				}
				
				injectors.put(type, ri);
			}
		}
		
		return injectors.get(type);
	}
	
	protected void configureInjectors() {
		injectors.put(GenericDAO.class, new DAOInjector());
	}

}
