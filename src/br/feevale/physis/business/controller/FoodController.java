package br.feevale.physis.business.controller;

import javax.annotation.Resource;

import br.feevale.physis.business.model.bean.Food;
import br.feevale.physis.business.model.dao.FoodDAO;
import br.feevale.physis.controller.CrudController;
import br.feevale.physis.dao.HibernateDAOImpl;

public class FoodController extends CrudController<Food> {

	@Resource
	private FoodDAO foodDAO;
	
	@Override
	protected HibernateDAOImpl<Food> getDao() {
		return foodDAO;
	}

	@Override
	protected String getListVarName() {
		return "foods";
	}

	@Override
	protected String getBeanVarName() {
		return "food";
	}

	@Override
	protected String getControllerName() {
		return "food";
	}

	@Override
	protected String getListViewName() {
		return "foodList";
	}

	@Override
	protected String getViewName() {
		return "food";
	}

}
