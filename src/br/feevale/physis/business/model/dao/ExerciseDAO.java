package br.feevale.physis.business.model.dao;

import br.feevale.physis.business.model.bean.Exercise;
import br.feevale.physis.dao.HibernateDAOImpl;

public class ExerciseDAO extends HibernateDAOImpl<Exercise> {

	@Override
	protected Class<Exercise> getBeanClass() {
		return Exercise.class;
	}

}
