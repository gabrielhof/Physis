package br.feevale.physis.dao.generic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.feevale.physis.exception.InvalidConnectionFactoryException;
import br.feevale.physis.factory.connection.ConnectionFactory;
import br.feevale.physis.model.Bean;
import br.feevale.physis.util.CollectionUtils;

public abstract class GenericDAOImpl<T extends Bean> implements GenericDAO<T> {
	
	private ConnectionFactory factory;
	
	@Override
	public void setConnectionFactory(ConnectionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		if (factory == null) {
			throw new InvalidConnectionFactoryException(null);
		}
		
		return factory.getConnection();
	}
	
	@Override
	public PreparedStatement executeQuery(String query) throws SQLException {
		return executeQuery(query, (List<Object>) null);
	}
	
	@Override
	public PreparedStatement executeQuery(String query, List<Object> parameters) throws SQLException {
		PreparedStatement stm = getConnection().prepareStatement(query);
		
		if (CollectionUtils.isNotEmpty(parameters)) {
			for (int i = 0; i < parameters.size(); i++) {
				stm.setObject(i+1, parameters.get(i));
			}
		}
		
		stm.execute();
		
		return stm;
	}

}
