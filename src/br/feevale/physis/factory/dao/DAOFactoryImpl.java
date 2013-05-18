package br.feevale.physis.factory.dao;

import java.util.Map;

import javax.annotation.Resource;

import br.feevale.physis.dao.PessoaDAO;
import br.feevale.physis.dao.generic.GenericDAO;
import br.feevale.physis.factory.connection.ConnectionFactory;
import br.feevale.physis.model.Bean;

public class DAOFactoryImpl implements DAOFactory {

	@Resource(type=PessoaDAO.class)
	private ConnectionFactory connectionFactory;
	
	private Map<Class<? extends GenericDAO<?>>, GenericDAO<?>> daos;
	
	@Override
	@SuppressWarnings("unchecked")
	public <T extends Bean> GenericDAO<T> getDAO(Class<? extends GenericDAO<T>> daoInterface) {
		try {
			if (!daos.containsKey(daoInterface)) {
				String implClassName = daoInterface.getName();
				Class<GenericDAO<T>> implClass = (Class<GenericDAO<T>>) Class.forName(implClassName + "Impl");
				GenericDAO<T> impl = implClass.newInstance();
				impl.setConnectionFactory(connectionFactory);
				daos.put(daoInterface, impl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (GenericDAO<T>) daos.get(daoInterface);
	}

}
