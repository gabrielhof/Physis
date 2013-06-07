package br.feevale.physis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import br.feevale.physis.factory.connection.ConnectionFactory;
import br.feevale.physis.model.Bean;

public interface GenericDAO<T extends Bean> {

	public void setConnectionFactory(ConnectionFactory factory);
	
	public Connection getConnection() throws Exception;
	
	public void close(Statement stm) throws Exception;
	
	public Integer executeInsertOrUpdate(String query, List<Object> parameters) throws Exception;
	
	public PreparedStatement executeQuery(String query) throws Exception;
	
	public PreparedStatement executeQuery(String query, Object... parameters) throws Exception;
	
	public PreparedStatement executeQuery(String query, List<Object> parameters) throws Exception;
	
	public T save(T bean) throws Exception;
	
	public boolean delete(T bean) throws Exception;
	
	public T get(Integer id) throws Exception;
	
	public List<T> listAll() throws Exception;
	
	public List<T> queryByExample(T example) throws Exception;
	
}
