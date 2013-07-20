package br.feevale.physis.business.model.dao;

import java.util.List;

import br.feevale.physis.business.model.bean.Person;
import br.feevale.physis.dao.HibernateDAOImpl;
import br.feevale.physis.util.CollectionUtils;

public class PersonDAO extends HibernateDAOImpl<Person>{

	public boolean isEmailAlreadyInUse(String email) throws Exception {
		Person example = new Person();
		example.setEmail(email);
		
		List<Person> person = queryByExample(example);
		return CollectionUtils.isEmpty(person);
	}
	
	@Override
	protected Class<Person> getBeanClass() {
		return Person.class;
	}
	
	
}
