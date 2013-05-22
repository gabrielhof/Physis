package br.feevale.physis.injector;

import java.lang.reflect.Field;

import br.feevale.physis.dao.generic.GenericDAO;
import br.feevale.physis.factory.dao.DAOFactory;
import br.feevale.physis.factory.dao.DAOFactoryImpl;
import br.feevale.physis.model.Bean;

public class DAOInjector implements ResourceInjector {

	public DAOFactory daoFactory;
	
	public DAOInjector() {
		daoFactory = DAOFactoryImpl.getInstance();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void inject(Object instance, Field fieldToInject) {
		if (!fieldToInject.isAccessible()) {
			fieldToInject.setAccessible(true);
		}
		
		GenericDAO<?> dao = daoFactory.getDAO((Class<? extends GenericDAO<Bean>>) fieldToInject.getType());
		
		try {
			fieldToInject.set(instance, dao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
