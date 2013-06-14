package br.feevale.physis.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.builder.controller.ActionControllerBuilder;
import br.feevale.physis.factory.controller.Controller;
import br.feevale.physis.factory.controller.ControllerFactory;
import br.feevale.physis.factory.controller.builder.ActionControllerBuilderFactory;
import br.feevale.physis.settings.ApplicationSettings;

@SuppressWarnings("serial")
public class DefaultServlet extends HttpServlet {

	private ActionControllerBuilderFactory actionControllerBuilderFactory;
	
	private ControllerFactory controllerFactory;
	
	private ApplicationSettings settings = ApplicationSettings.getInstance();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		settings.setSettings(config);
		
		this.controllerFactory = settings.getControllerFactory();
		this.actionControllerBuilderFactory = settings.getActionControllerBuilderFactory();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			ActionControllerBuilder builder = actionControllerBuilderFactory.create(request);
			
			request.setAttribute("controller", builder.getController());
			request.setAttribute("action", builder.getAction());
			
			// Procura pelo controller e invoca a action
			Controller controller = controllerFactory.create(builder.getController());
			controller.invoke(builder.getAction(), request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
