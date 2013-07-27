package br.feevale.physis.business.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.builder.view.ViewBuilder;
import br.feevale.physis.business.model.bean.Evaluation;
import br.feevale.physis.business.model.bean.User;
import br.feevale.physis.business.model.dao.EvaluationDAO;
import br.feevale.physis.business.model.dao.PersonDAO;
import br.feevale.physis.business.model.dao.TrainingDAO;
import br.feevale.physis.business.model.enums.Role;
import br.feevale.physis.business.session.UserSession;
import br.feevale.physis.controller.CrudController;
import br.feevale.physis.dao.HibernateDAOImpl;
import br.feevale.physis.view.View;

public class EvaluationController extends CrudController<Evaluation> {

	@Resource
	private EvaluationDAO evaluationDAO;

	@Resource
	private PersonDAO personDAO;

	@Resource
	private TrainingDAO trainingDAO;
	
	@Override
	public void indexAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = UserSession.getUser(request);
		
		List<Evaluation> list = null;
		if (user.getRole() != Role.USER) {
			list = evaluationDAO.listAll();
		} else {
			list = evaluationDAO.findOf(user.getPerson());
		}
		
		View view = ViewBuilder.build(getControllerName(), getListViewName());
		view.setVariable(getListVarName(), list);
		view.forward(request, response);
	}
	
	@Override
	protected void buildVariables(View view) throws Exception {
		view.setVariable("users", personDAO.findFor(Role.USER));
		view.setVariable("professors", personDAO.findFor(Role.PROFESSOR));
		view.setVariable("training", trainingDAO.listAll());
	}
	
	@Override
	protected HibernateDAOImpl<Evaluation> getDao() {
		return evaluationDAO;
	}

	@Override
	protected String getListVarName() {
		return "evaluationList";
	}

	@Override
	protected String getBeanVarName() {
		return "evaluation";
	}

	@Override
	protected String getControllerName() {
		return "evaluation";
	}

	@Override
	protected String getListViewName() {
		return "evaluationList";
	}

	@Override
	protected String getViewName() {
		return "evaluation";
	}
}