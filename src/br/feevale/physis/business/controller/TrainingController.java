package br.feevale.physis.business.controller;

import javax.annotation.Resource;

import br.feevale.physis.business.model.bean.Training;
import br.feevale.physis.business.model.bean.TrainingExercise;
import br.feevale.physis.business.model.dao.ExerciseDAO;
import br.feevale.physis.business.model.dao.TrainingDAO;
import br.feevale.physis.controller.CrudController;
import br.feevale.physis.dao.HibernateDAOImpl;
import br.feevale.physis.util.CollectionUtils;
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
	protected void beforeSave(Training bean) throws Exception {
		if (CollectionUtils.isNotEmpty(bean.getTrainingExercises())) {
			for (TrainingExercise te : bean.getTrainingExercises()) {
				te.setTraining(bean);
				te.setExercise(exerciseDAO.get(te.getExercise().getId()));
			}
		}
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
