package br.feevale.physis.business.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.business.model.bean.Training;
import br.feevale.physis.business.model.dao.ExerciseDAO;
import br.feevale.physis.business.model.dao.TrainingDAO;
import br.feevale.physis.controller.CrudController;
import br.feevale.physis.dao.HibernateDAOImpl;
import br.feevale.physis.view.View;

public class TrainingController extends CrudController<Training>{

	@Resource
	private TrainingDAO trainingDAO;
	
	@Resource
	private ExerciseDAO exerciseDAO;
	
	@Override
	protected void buildVariables(View view) throws Exception {
		view.setVariable("exercises", exerciseDAO.listAll());
	}
	
	@Override
	public void saveAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(request.getParameterValues("training.trainingExercise.exercise.id"));
	}
	
	@Override
	protected HibernateDAOImpl<Training> getDao() {
		return trainingDAO;
	}

	@Override
	protected String getListVarName() {
		return "trainingList";
	}

	@Override
	protected String getBeanVarName() {
		return "training";
	}

	@Override
	protected String getControllerName() {
		return "training";
	}

	@Override
	protected String getListViewName() {
		return "trainingList";
	}

	@Override
	protected String getViewName() {
		return "training";
	}

}
