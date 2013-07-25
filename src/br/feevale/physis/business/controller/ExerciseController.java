package br.feevale.physis.business.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.annotation.Request;
import br.feevale.physis.builder.view.ViewBuilder;
import br.feevale.physis.business.model.bean.Exercise;
import br.feevale.physis.business.model.dao.EquipmentDAO;
import br.feevale.physis.business.model.dao.ExerciseDAO;
import br.feevale.physis.controller.DefaultController;
import br.feevale.physis.converter.RequestConverter;
import br.feevale.physis.converter.impl.BeanRequestConverter;
import br.feevale.physis.enums.RequestMethod;
import br.feevale.physis.util.RequestUtils;
import br.feevale.physis.util.StringUtils;
import br.feevale.physis.view.View;

public class ExerciseController implements DefaultController {

	@Resource
	private ExerciseDAO exerciseDAO;
	
	@Resource
	private EquipmentDAO equipmentDAO;
	
	@Override
	public void indexAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Exercise> exercises = exerciseDAO.listAll();
		
		View view = ViewBuilder.build("exercise", "exerciseList");
		view.setVariable("exercises", exercises);
		view.forward(request, response);
	}
	
	public void newAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		View view = ViewBuilder.build("exercise", "exercise");
		view.setVariable("equipments", equipmentDAO.listAll());
		view.forward(request, response);
	}
	
	public void editAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		View view = ViewBuilder.build("exercise", "exercise");
		view.setVariable("equipments", equipmentDAO.listAll());
		
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id)) {
			Exercise exercise = exerciseDAO.get(Integer.parseInt(id));
			view.setVariable("exercise", exercise);
		}
		
		view.forward(request, response);
	}

	@Request(methods=RequestMethod.POST)
	public void saveAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestConverter<Exercise> converter = new BeanRequestConverter<Exercise>(request, Exercise.class);
		Exercise exercise = converter.convert();
		
		if (exercise.getEquipment().getId() != null) {
			exercise.setEquipment(equipmentDAO.get(exercise.getEquipment().getId()));
		} else {
			exercise.setEquipment(null);
		}
		
		exerciseDAO.save(exercise);
		RequestUtils.redirect(request, response, "exercise");
	}
	
	@Request(methods=RequestMethod.POST)
	public void deleteAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id)) {
			Exercise exercise = new Exercise();
			exercise.setId(new Integer(id));
			
			exerciseDAO.delete(exercise);
		}
		
		RequestUtils.redirect(request, response, "exercise");
	}
	
}
