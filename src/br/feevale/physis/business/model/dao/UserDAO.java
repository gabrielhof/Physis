package br.feevale.physis.business.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.feevale.physis.business.model.bean.User;
import br.feevale.physis.dao.GenericDAOImpl;
import br.feevale.physis.util.StringUtils;

public class UserDAO extends GenericDAOImpl<User> {

	@Override
	public User save(User bean) throws Exception {
		List<Object> parameters = new ArrayList<Object>();
		StringBuilder query = new StringBuilder();
		
		if (bean.getId() == null) {
			query.append("INSERT INTO users ");
			query.append("(username, password) ");
			query.append("VALUES (?, ?) ");
			
			parameters.add(bean.getUsername());
			parameters.add(bean.getPassword());
		} else {
			query.append("UPDATE users SET ");
			
			query.append(" username=? ");
			parameters.add(bean.getUsername());
			
			query.append(",password=? ");
			parameters.add(bean.getPassword());
			
			query.append("WHERE id = ? ");
			parameters.add(bean.getId());
		}
		
		Integer id = executeInsertOrUpdate(query.toString(), parameters);
		
		if (id != null) {
			bean.setId(id);
		}
		
		return bean;
	}

	@Override
	public boolean delete(User bean) throws Exception {
		if (bean != null && bean.getId() != null) {
			PreparedStatement stm = executeQuery("DELETE FROM users WHERE id = ?", bean.getId());
			close(stm);
			
			return true;
		}
		
		return false;
	}

	@Override
	public User get(Integer id) throws Exception {
		PreparedStatement stm = executeQuery("SELECT * FROM users WHERE id = ?", id);
		ResultSet rs = stm.getResultSet();
		
		User user = null;
		while (rs.next()) {
			user = getDefaultUser(rs);
			break;
		}
		
		close(stm);
		
		return user;
	}

	public User get(String username, String password) throws Exception {
		List<Object> parameters = new ArrayList<Object>();
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT * FROM users ");
		query.append("WHERE username = ? ");
		parameters.add(username);
		
		query.append("AND password = ? ");
		parameters.add(password);
		
		PreparedStatement stm = executeQuery(query.toString(), parameters);
		ResultSet rs = stm.getResultSet();
		
		User user = null;
		while (rs.next()) {
			user = getDefaultUser(rs);
			break;
		}
		
		close(stm);
		
		return user;
	}
	
	@Override
	public List<User> listAll() throws Exception {
		PreparedStatement stm = executeQuery("SELECT * FROM users");
		ResultSet rs = stm.getResultSet();
		
		List<User> result = new ArrayList<User>();
		while (rs.next()) {
			result.add(getDefaultUser(rs));
		}
		
		close(stm);
		
		return result;
	}

	@Override
	public List<User> queryByExample(User example) throws Exception {
		List<Object> parameters = new ArrayList<Object>();
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT * FROM users ");
		query.append("WHERE 1=1 ");
		
		if (example.getId() != null) {
			query.append("AND id = ? ");
			parameters.add(example.getId());
		}
		
		if (StringUtils.isNotBlank(example.getUsername())) {
			query.append("AND username = ? ");
			parameters.add(example.getUsername());
		}
		
		if (StringUtils.isNotBlank(example.getUsername())) {
			query.append("AND password = ? ");
			parameters.add(example.getPassword());
		}
		
		PreparedStatement stm = executeQuery(query.toString(), parameters);
		ResultSet rs = stm.getResultSet();
		
		List<User> result = new ArrayList<User>();
		while (rs.next()) {
			result.add(getDefaultUser(rs));
		}
		
		close(stm);
		
		return result;
	}
	
	public User getDefaultUser(ResultSet rs) throws Exception {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		
		return user;
	}

}