package org.teste.dao.generic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.teste.model.Bean;
import org.teste.util.CollectionUtils;

public abstract class GenericDAOImpl<T extends Bean> implements GenericDAO<T> {
	
	@Override
	public Connection getConnection() {
		return null;
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
