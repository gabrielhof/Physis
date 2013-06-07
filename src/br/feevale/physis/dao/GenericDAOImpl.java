package br.feevale.physis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
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
	public Connection getConnection() throws Exception {
		if (factory == null) {
			throw new InvalidConnectionFactoryException(null);
		}
		
		return factory.getConnection();
	}
	
	@Override
	public void close(Statement stm) throws Exception {
		Connection conn = stm.getConnection();
		
		stm.close();
		conn.close();
	}
	
	@Override
	public Integer executeInsertOrUpdate(String query, List<Object> parameters) throws Exception {
		PreparedStatement stm = executeQuery(query, parameters);
		ResultSet rs = stm.getGeneratedKeys();
		
		Integer result = null;
		if (rs.next()) {
			result = rs.getInt(1);
		}
		
		close(stm);
		
		return result;
	}
	
	@Override
	public PreparedStatement executeQuery(String query) throws Exception {
		return executeQuery(query, (List<Object>) null);
	}
	
	@Override
	public PreparedStatement executeQuery(String query, Object... parameters) throws Exception {
		List<Object> parametersList = null;
		if (parameters != null) {
			parametersList = Arrays.asList(parameters);
		}
		
		return executeQuery(query, parametersList);
	}
	
	@Override
	public PreparedStatement executeQuery(String query, List<Object> parameters) throws Exception {
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
