package br.feevale.physis.business.model.dao;

import br.feevale.physis.business.model.bean.Training;
import br.feevale.physis.dao.HibernateDAOImpl;

public class TrainingDAO extends HibernateDAOImpl<Training> {

	@Override
	public Class<Training> getBeanClass() {
		return Training.class;
	}

}
