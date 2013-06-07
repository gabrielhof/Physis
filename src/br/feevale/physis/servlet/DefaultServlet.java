package br.feevale.physis.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.factory.controller.Controller;
import br.feevale.physis.factory.controller.ControllerFactory;
import br.feevale.physis.settings.ApplicationSettings;

@SuppressWarnings("serial")
public class DefaultServlet extends HttpServlet {

	private ControllerFactory controllerFactory;
	
	private ApplicationSettings settings = ApplicationSettings.getInstance();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		settings.setSettings(config);
		this.controllerFactory = settings.getControllerFactory();
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
			String url[] = request.getRequestURI().split("/");
			
			String controllerName = null;
			
			if (url.length == 4) {
				//Caso o tamanho da url seja 4, o valor da ultima posicao da url sera o controller 
				controllerName = url[3];
			} else if (url.length > 4) {
				//Se for maior que 4, o controller sera a penultima posicao da url
				controllerName = url[url.length-2]; //
			} else {
				//Caso seja menor que 4, nao havera controller e o default sera o 'index'
				controllerName = "index";
			}
			
			/*
			 * Verifica se a url possui mais de 4 posicoes, a ultima posicao sera a action.
			 * Caso contrario a action sera a 'index'
			 */
			String action = url.length > 4 ? url[url.length-1] : "index";
			
			request.setAttribute("controller", controllerName);
			request.setAttribute("action", action);
			
			// Procura pelo controller e invoca a action
			Controller controller = controllerFactory.create(controllerName);
			controller.invoke(action, request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
