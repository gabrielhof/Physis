package br.feevale.physis.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseUtils {

	public static void redirect(HttpServletRequest request, HttpServletResponse response, String controller) throws IOException {
		response.sendRedirect(String.format("%s%s/%s", request.getContextPath(), request.getServletPath(), controller));
	}
	
	public static void redirect(HttpServletRequest request, HttpServletResponse response, String controller, String action) throws IOException {
		response.sendRedirect(String.format("%s%s/%s/%s", request.getContextPath(), request.getServletPath(), controller, action));
	}
	
}
