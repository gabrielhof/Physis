package br.feevale.physis.view;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.exception.InvalidViewException;
import br.feevale.physis.util.StringUtils;

public class ResponseView implements View {

	protected static final String VIEW_FOLDER = "/view";
	protected static final String VIEW_SUFIX = "View";
	
	protected String controller;
	protected String view;
	
	protected Map<String, Object> variables;
	
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

	protected void setRequestAttributes(HttpServletRequest request) {
		Collection<String> variables = getVariables();
		for (String variable : variables) {
			request.setAttribute(variable, getVariable(variable));
		}
	}
	
	@Override
	public void setVariable(String name, Object value) {
		variables.put(name, value);
	}
	
	@Override
	public Object getVariable(String name) {
		return variables.get(name);
	}
	
	@Override
	public Collection<String> getVariables() {
		return variables.keySet();
	}
	
	public String getController() {
		return controller;
	}
	
	public String getView() {
		return view;
	}
	
	@Override
	public void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		configureDefaultVariables(request);
		setRequestAttributes(request);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(buildUrl(request));
		dispatcher.forward(request, response);
	}
	
	protected String buildUrl(HttpServletRequest request) {
		return String.format("%s/%s/%s%s.jsp", VIEW_FOLDER, controller, view, VIEW_SUFIX);
	}
	
}
