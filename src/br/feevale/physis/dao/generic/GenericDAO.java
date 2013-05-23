package br.feevale.physis.dao.generic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.feevale.physis.factory.connection.ConnectionFactory;
import br.feevale.physis.model.Bean;

public interface GenericDAO<T extends Bean> {

	public void setConnectionFactory(ConnectionFactory factory);
	
	public Connection getConnection() throws SQLException;
	
	public void close(Statement stm) throws SQLException;
	
	public PreparedStatement executeQuery(String query) throws SQLException;
	
	public PreparedStatement executeQuery(String query, List<Object> parameters) throws SQLException;
	
	public Integer save(T bean) throws SQLException;
	
	public boolean delete(T bean) throws SQLException;
	
	public T get(Integer id) throws SQLException;
	
	public List<T> listAll() throws SQLException;
	
	public List<T> queryByExample(T example) throws SQLException;
	
}
