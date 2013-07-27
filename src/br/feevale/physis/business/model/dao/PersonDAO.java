package br.feevale.physis.business.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.feevale.physis.business.model.bean.Person;
import br.feevale.physis.business.model.enums.Role;
import br.feevale.physis.dao.HibernateDAOImpl;
import br.feevale.physis.util.CollectionUtils;

public class PersonDAO extends HibernateDAOImpl<Person>{

	public boolean isEmailAlreadyInUse(String email) throws Exception {
		Person example = new Person();
		example.setEmail(email);
		
		List<Person> person = queryByExample(example);
		return CollectionUtils.isEmpty(person);
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> findFor(Role role) throws Exception {
		Session session = getHibernateSession();
		
		Criteria criteria = session.createCriteria(Person.class, "pers");
		criteria.createAlias("pers.user", "user").setFetchMode("pers.user", FetchMode.JOIN);
		criteria.add(Restrictions.eq("user.role", role));
		
		List<Person> result = criteria.list();
		
		session.close();
		
		return result;
	}
	
	@Override
	public Class<Person> getBeanClass() {
		return Person.class;
	}
	
	
}
