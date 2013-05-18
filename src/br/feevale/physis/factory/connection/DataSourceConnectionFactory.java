package br.feevale.physis.factory.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import br.feevale.physis.exception.CannotCreateConnectionFactoryException;

public class DataSourceConnectionFactory implements ConnectionFactory {

	private DataSource dataSource;
	
	public DataSourceConnectionFactory() throws CannotCreateConnectionFactoryException {
		try {
			Context initialContext = new InitialContext();
			dataSource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/physis");
		} catch (NamingException e) {
			throw new CannotCreateConnectionFactoryException(e);
		}
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
