package br.feevale.physis.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestUtils {

	public static void redirect(HttpServletRequest request, HttpServletResponse response, String controller) throws IOException {
		response.sendRedirect(String.format("%s%s/%s", request.getContextPath(), request.getServletPath(), controller));
	}
	
	public static void redirect(HttpServletRequest request, HttpServletResponse response, String controller, String action) throws IOException {
		response.sendRedirect(String.format("%s%s/%s/%s", request.getContextPath(), request.getServletPath(), controller, action));
	}
	
	public static Map<String, String> getRequestParameters(HttpServletRequest request) {
		Map<String, String> parameters = new HashMap<String, String>();
		
		Enumeration<String> requestParamNames = request.getParameterNames();
		while (requestParamNames.hasMoreElements()) {
			String paramName = requestParamNames.nextElement();
			parameters.put(paramName, request.getParameter(paramName));
		}
		
		return parameters;
	}
	
}
