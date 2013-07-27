package br.feevale.physis.business.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.annotation.Request;
import br.feevale.physis.builder.view.ViewBuilder;
import br.feevale.physis.business.model.bean.Person;
import br.feevale.physis.business.model.bean.User;
import br.feevale.physis.business.model.dao.PersonDAO;
import br.feevale.physis.business.model.dao.UserDAO;
import br.feevale.physis.business.session.UserSession;
import br.feevale.physis.controller.DefaultController;
import br.feevale.physis.converter.RequestConverter;
import br.feevale.physis.converter.impl.BeanRequestConverter;
import br.feevale.physis.enums.RequestMethod;
import br.feevale.physis.enums.RequestType;
import br.feevale.physis.util.EncryptpUtils;
import br.feevale.physis.util.RequestUtils;
import br.feevale.physis.util.StringUtils;
import br.feevale.physis.view.JsonResponse;
import br.feevale.physis.view.View;

public class PersonController implements DefaultController {

	@Resource
	private PersonDAO personDAO;
	
	@Resource
	private UserDAO userDAO;
	
	@Override
	public void indexAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Person> people = personDAO.listAll();
		
		View indexView = ViewBuilder.build("person", "personList");
		indexView.setVariable("people", people);
		indexView.forward(request, response);
	}
	
	public void newAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		View view = ViewBuilder.build("person", "person");
		view.forward(request, response);
	}
	
	public void editAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		View view = ViewBuilder.build("person", "person");
		
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id)) {
			Person person = personDAO.get(Integer.parseInt(id));
			view.setVariable("person", person);
		}
		
		view.forward(request, response);
	}
	
	@Request(methods=RequestMethod.POST)
	public void saveAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestConverter<Person> converter = new BeanRequestConverter<Person>(request, Person.class);
		Person person  = converter.convert();
		
		person.getAddress().setPerson(person);
		person.getUser().setPerson(person);

		User user = person.getUser();
		if (user.getId() != null && StringUtils.isBlank(user.getPassword())) {
			User originalUser = userDAO.get(user.getId());
			user.setPassword(originalUser.getPassword());
		} else {
			user.setPassword(EncryptpUtils.md5(user.getPassword()));
		}
		
		personDAO.save(person);
		RequestUtils.redirect(request, response, "person");
	}
	
	@Request(methods=RequestMethod.POST)
	public void deleteAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id)) {
			Person person = new Person();
			person.setId(new Integer(id));
			
			User user = UserSession.getUser(request);
			
			if (user.getPerson().getId() < person.getId()) {
				personDAO.delete(person);
			}
		}
		
		RequestUtils.redirect(request, response, "person");
	}
	
	@Request(type=RequestType.AJAX, methods=RequestMethod.POST)
	public void validateEmail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = request.getParameter("email");
		boolean isEmailUsed = personDAO.isEmailAlreadyInUse(email);
		
		JsonResponse jsonResponse = new JsonResponse(isEmailUsed);
		jsonResponse.respond(response);
	}
	
	@Request(type=RequestType.AJAX, methods=RequestMethod.POST)
	public void validateUsername(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		boolean isUsernameUsed = userDAO.isUsernameTaken(username);
		
		JsonResponse jsonResponse = new JsonResponse(isUsernameUsed);
		jsonResponse.respond(response);
	}

}
