package org.teste.dao.generic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.teste.model.Bean;

public interface GenericDAO<T extends Bean> {

	public Connection getConnection();
	
	public PreparedStatement executeQuery(String query) throws SQLException;
	
	public PreparedStatement executeQuery(String query, List<Object> parameters) throws SQLException;
	
	public boolean save(T bean);
	
	public boolean delete(T bean);
	
	public T get(Integer id);
	
	public List<T> listAll();
	
	public List<T> queryByExample(T example);
	
}
