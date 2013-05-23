package br.feevale.physis.view;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.exception.InvalidViewException;
import br.feevale.physis.util.StringUtils;

public class ResponseView implements View {

	private static final String VIEW_FOLDER = "/view";
	private static final String VIEW_SUFIX = "View";
	
	private String controller;
	private String view;
	
	private Map<String, Object> variables;
	
	public ResponseView(String controller, String view) throws InvalidViewException {
		if (StringUtils.isBlank(controller) || StringUtils.isBlank(view)) {
			throw new InvalidViewException(controller, view);
		}
		
		this.controller = controller;
		this.view = StringUtils.capitalizeFirst(view);
		this.variables = new HashMap<String, Object>();
	}
	
	protected void configureDefaultVariables(HttpServletRequest request) {
		setVariable("contextPath", request.getContextPath());
	}

	@Override
	public void setVariable(String name, Object value) {
		variables.put(name, value);
	}
	
	@Override
	public void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		configureDefaultVariables(request);
		
		for (String variable : variables.keySet()) {
			request.setAttribute(variable, variables.get(variable));
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(String.format("%s/%s/%s%s.jsp", VIEW_FOLDER, controller, view, VIEW_SUFIX));
		dispatcher.forward(request, response);
	}
	
}
