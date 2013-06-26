package br.feevale.physis.business.model.dao;

import java.util.List;

import br.feevale.physis.business.model.bean.User;
import br.feevale.physis.dao.HibernateDAOImpl;
import br.feevale.physis.util.EncryptpUtils;

public class UserDAO extends HibernateDAOImpl<User> {

	@Override
	protected Class<User> getBeanClass() {
		return User.class;
	}

	public User get(String username, String password) throws Exception {
		User example = new User();
		example.setUsername(username);
		example.setPassword(EncryptpUtils.md5(password));
		
		List<User> users = queryByExample(example);
		for (User user : users) {
			return user;
		}
		
		return null;
	}

}