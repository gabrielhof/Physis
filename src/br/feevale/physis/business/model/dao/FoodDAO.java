package br.feevale.physis.business.model.dao;

import br.feevale.physis.business.model.bean.Food;
import br.feevale.physis.dao.HibernateDAOImpl;

public class FoodDAO extends HibernateDAOImpl<Food> {

	@Override
	public Class<Food> getBeanClass() {
		return Food.class;
	}

}
