package br.feevale.physis.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.factory.controller.Controller;
import br.feevale.physis.factory.controller.ControllerFactory;
import br.feevale.physis.factory.controller.ControllerFactoryImpl;
import br.feevale.physis.util.StringUtils;

@SuppressWarnings("serial")
public class DefaultServlet extends HttpServlet {

	private ControllerFactory controllerFactory;
	
	@Override
	public void init() throws ServletException {
		this.controllerFactory = new ControllerFactoryImpl();
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
				controllerName = url[3];
			} else if (url.length > 4) {
				controllerName = url[url.length-2];
			}
			
			if (StringUtils.isBlank(controllerName)) {
				String requestURI = request.getRequestURI().replaceFirst("/$", "");
				response.sendRedirect(requestURI + "/index/");
				return;
			}
			
			String action = url.length > 4 ? url[url.length-1] : "index";
			
			Controller controller = controllerFactory.create(controllerName);
			controller.invoke(action, request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
