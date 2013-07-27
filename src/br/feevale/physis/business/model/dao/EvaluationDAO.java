package br.feevale.physis.business.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.feevale.physis.business.model.bean.Evaluation;
import br.feevale.physis.business.model.bean.Person;
import br.feevale.physis.dao.HibernateDAOImpl;

public class EvaluationDAO extends HibernateDAOImpl<Evaluation> {

	@SuppressWarnings("unchecked")
	public List<Evaluation> findOf(Person person) throws Exception {
		Session session = getHibernateSession();
		
		Query query = session.createQuery("select eval from Evaluation eval where eval.user = :user");
		query.setParameter("user", person);
		
		List<Evaluation> list = query.list();
		
		session.close();
		
		return list;
	}
	
	@Override
	public Class<Evaluation> getBeanClass() {
		return Evaluation.class;
	}

}
