package br.feevale.physis.business.model.dao;

import java.util.List;

import br.feevale.physis.business.model.bean.User;
import br.feevale.physis.dao.HibernateDAOImpl;
import br.feevale.physis.util.CollectionUtils;
import br.feevale.physis.util.EncryptpUtils;
import br.feevale.physis.util.StringUtils;

public class UserDAO extends HibernateDAOImpl<User> {

	@Override
	public Class<User> getBeanClass() {
		return User.class;
	}

	public User get(String username, String password) throws Exception {
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			return null;
		}
		
		User example = new User();
		example.setUsername(username);
		example.setPassword(EncryptpUtils.md5(password));
		
		List<User> users = queryByExample(example);
		for (User user : users) {
			return user;
		}
		
		return null;
	}
	
	public boolean isUsernameTaken(String username) throws Exception {
		User example = new User();
		example.setUsername(username);
		
		List<User> users = queryByExample(example);
		return CollectionUtils.isEmpty(users);
	}

}