package br.feevale.physis.view;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface View {

	public void setVariable(String name, Object value);
	public Object getVariable(String name);
	public Collection<String> getVariables();
	
	public void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
