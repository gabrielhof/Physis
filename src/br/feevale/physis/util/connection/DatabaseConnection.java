package br.feevale.physis.util.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DatabaseConnection {
	
	private static DatabaseConnection INSTANCE;
	
	public static DatabaseConnection getConnection() {
		if (INSTANCE == null) {
			try {
				INSTANCE = new DatabaseConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return INSTANCE;
	}
	
	private Connection conn;
	
	private DatabaseConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=maxprint");
	}

	public ResultSet query(String query) {
		return query(query, null);
	}
	
	public ResultSet query(String query, List<Object> parameters) {
		try {
			PreparedStatement stm = conn.prepareStatement(query);
			
			if (parameters != null) {
				for (int i = 0; i < parameters.size(); i++) {
					stm.setObject(i, parameters.get(i));
				}
			}
			
			stm.execute();
			
			return stm.getResultSet();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void closeResult(ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.getStatement().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
