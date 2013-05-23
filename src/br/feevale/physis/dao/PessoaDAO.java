package br.feevale.physis.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.feevale.physis.dao.generic.GenericDAOImpl;
import br.feevale.physis.model.Pessoa;

public class PessoaDAO extends GenericDAOImpl<Pessoa>{
	
	@Override
	public Integer save(Pessoa bean) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Pessoa bean) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pessoa get(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> listAll() throws SQLException {
		PreparedStatement stm = executeQuery("SELECT * FROM pessoas");
		ResultSet rs = stm.getResultSet();

		List<Pessoa> list = new ArrayList<Pessoa>();

		while (rs.next()) {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id"));
			pessoa.setName(rs.getString("name"));
			pessoa.setAge(rs.getInt("age"));

			list.add(pessoa);
		}
		
		close(stm);
		return list;
	}

	@Override
	public List<Pessoa> queryByExample(Pessoa example) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
