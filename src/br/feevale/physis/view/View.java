package br.feevale.physis.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface View {

	public void setVariable(String name, Object value);
	
	public void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
