package br.feevale.physis.business.model.dao;

import br.feevale.physis.business.model.bean.Person;
import br.feevale.physis.dao.HibernateDAOImpl;

public class PersonDAO extends HibernateDAOImpl<Person>{

	@Override
	protected Class<Person> getBeanClass() {
		return Person.class;
	}
	
	
}
