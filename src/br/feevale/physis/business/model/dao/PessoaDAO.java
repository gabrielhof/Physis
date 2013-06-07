package br.feevale.physis.business.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.feevale.physis.business.model.bean.Pessoa;
import br.feevale.physis.dao.GenericDAOImpl;

public class PessoaDAO extends GenericDAOImpl<Pessoa>{
	
	@Override
	public Pessoa save(Pessoa bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Pessoa bean) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pessoa get(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> listAll() throws Exception {
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
	public List<Pessoa> queryByExample(Pessoa example) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
