package br.feevale.physis.factory.dao;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import br.feevale.physis.dao.GenericDAO;
import br.feevale.physis.model.Bean;

public class DAOFactoryImpl implements DAOFactory {

	public static DAOFactoryImpl INSTANCE;
	
	public static DAOFactoryImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DAOFactoryImpl();
		}
		
		return INSTANCE;
	}
	
	private Map<Class<? extends GenericDAO<?>>, GenericDAO<?>> daos;

	private DAOFactoryImpl() {
		try {
			daos = new HashMap<Class<? extends GenericDAO<?>>, GenericDAO<?>>();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T extends Bean> GenericDAO<T> getDAO(Class<? extends GenericDAO<T>> daoInterface) {
		try {
			if (!daos.containsKey(daoInterface)) {
				GenericDAO<T> impl = null;
				
				if (daoInterface.isInterface() || Modifier.isAbstract(daoInterface.getModifiers())) {
					String implClassName = daoInterface.getName();
					Class<GenericDAO<T>> implClass = (Class<GenericDAO<T>>) Class.forName(implClassName + "Impl");
					
					impl = implClass.newInstance();
				} else {
					impl = daoInterface.newInstance();
				}
				
				daos.put(daoInterface, impl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (GenericDAO<T>) daos.get(daoInterface);
	}

}
