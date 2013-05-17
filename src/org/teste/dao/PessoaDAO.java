package org.teste.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.teste.model.Pessoa;
import org.teste.util.connection.DatabaseConnection;

public class PessoaDAO {
	
	public PessoaDAO() {
	}
	
	public List<Pessoa> getList() {
		ResultSet rs = DatabaseConnection.getConnection().query("SELECT * FROM pessoas");
		
		List<Pessoa> list = new ArrayList<Pessoa>();
		try {
			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(rs.getInt("id"));
				pessoa.setName(rs.getString("name"));
				pessoa.setAge(rs.getInt("age"));
				
				list.add(pessoa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DatabaseConnection.getConnection().closeResult(rs);
		
		return list;
	}
	
}
