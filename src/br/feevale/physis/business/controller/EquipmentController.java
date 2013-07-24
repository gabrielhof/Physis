package br.feevale.physis.business.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.annotation.Request;
import br.feevale.physis.builder.view.ViewBuilder;
import br.feevale.physis.business.model.bean.Equipment;
import br.feevale.physis.business.model.dao.EquipementDAO;
import br.feevale.physis.controller.DefaultController;
import br.feevale.physis.converter.RequestConverter;
import br.feevale.physis.converter.impl.BeanRequestConverter;
import br.feevale.physis.enums.RequestMethod;
import br.feevale.physis.util.RequestUtils;
import br.feevale.physis.util.StringUtils;
import br.feevale.physis.view.View;

public class EquipmentController implements DefaultController {

	@Resource
	private EquipementDAO equipmentDAO;
	
	@Override
	public void indexAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Equipment> equipments = equipmentDAO.listAll();
		
		View view = ViewBuilder.build("equipment", "EquipmentList");
		view.setVariable("equipments", equipments);
		view.forward(request, response);
	}
	
	public void newAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		View view = ViewBuilder.build("equipment", "equipment");
		view.forward(request, response);
	}
	
	public void editAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		View view = ViewBuilder.build("equipment", "equipment");
		
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id)) {
			Equipment equipment = equipmentDAO.get(Integer.parseInt(id));
			view.setVariable("equipment", equipment);
		}
		
		view.forward(request, response);
	}

	@Request(methods=RequestMethod.POST)
	public void saveAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestConverter<Equipment> converter = new BeanRequestConverter<Equipment>(request, Equipment.class);
		Equipment equipment  = converter.convert();
		
		equipmentDAO.save(equipment);
		RequestUtils.redirect(request, response, "equipment");
	}
	
	@Request(methods=RequestMethod.POST)
	public void deleteAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id)) {
			Equipment equipament = new Equipment();
			equipament.setId(new Integer(id));
			
			equipmentDAO.delete(equipament);
		}
		
		RequestUtils.redirect(request, response, "equipment");
	}
	
}
