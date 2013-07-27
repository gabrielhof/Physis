package br.feevale.physis.business.model.dao;

import br.feevale.physis.business.model.bean.Evaluation;
import br.feevale.physis.dao.HibernateDAOImpl;

public class EvaluationDAO extends HibernateDAOImpl<Evaluation> {

	@Override
	public Class<Evaluation> getBeanClass() {
		return Evaluation.class;
	}

}
