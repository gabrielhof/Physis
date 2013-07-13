package br.feevale.physis.business.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.business.model.bean.Person;
import br.feevale.physis.business.model.dao.PersonDAO;
import br.feevale.physis.controller.DefaultController;
import br.feevale.physis.builder.view.ViewBuilder;
import br.feevale.physis.view.View;

public class PersonController implements DefaultController {

	@Resource
	private PersonDAO personDAO;
	
	@Override
	public void indexAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Person> people = personDAO.listAll();
		
		View indexView = ViewBuilder.build("person", "person");
		indexView.setVariable("people", people);
		indexView.forward(request, response);
	}

}
