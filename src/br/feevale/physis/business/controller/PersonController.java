package br.feevale.physis.business.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.annotation.Request;
import br.feevale.physis.builder.view.ViewBuilder;
import br.feevale.physis.business.model.bean.Person;
import br.feevale.physis.business.model.dao.PersonDAO;
import br.feevale.physis.controller.DefaultController;
import br.feevale.physis.converter.RequestConverter;
import br.feevale.physis.converter.impl.BeanRequestConverter;
import br.feevale.physis.enums.RequestMethod;
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
	
	public void newAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		View view = ViewBuilder.build("person", "newPerson");
		view.forward(request, response);	
	}
	
	@Request(methods=RequestMethod.POST)
	public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestConverter<Person> converter = new BeanRequestConverter<Person>(request, Person.class);
		Person person  = converter.convert();
		
		person.getAddress().setPerson(person);
		
		System.out.println(person);
	}

}
