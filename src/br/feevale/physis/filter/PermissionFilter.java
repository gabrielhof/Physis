package br.feevale.physis.filter;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import resources.Resources;
import br.feevale.physis.builder.controller.ActionControllerBuilder;
import br.feevale.physis.business.model.bean.User;
import br.feevale.physis.business.model.enums.Role;
import br.feevale.physis.business.session.UserSession;
import br.feevale.physis.exception.PermissionException;
import br.feevale.physis.factory.controller.builder.ActionControllerBuilderFactory;
import br.feevale.physis.settings.ApplicationSettings;

public class PermissionFilter implements Filter {

	private ApplicationSettings settings = ApplicationSettings.getInstance();
	private ActionControllerBuilderFactory actionControllerBuilderFactory;
	
	private XPath xPath;
	private Document menuDocument;
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		try {
			InputStream in = Resources.getResource(Resources.APPLICATION_MENU);
			
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			menuDocument = builder.parse(in);
			xPath = XPathFactory.newInstance().newXPath();
			
			in.close();
			
			actionControllerBuilderFactory = settings.getActionControllerBuilderFactory();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			User user = UserSession.getUser((HttpServletRequest) request);
			
			if (user != null) {
				ActionControllerBuilder builder = actionControllerBuilderFactory.create((HttpServletRequest) request);
				
				String controller = builder.getController();
				String action = builder.getAction();
				String otherAction = action;
				
				if ("index".equalsIgnoreCase(otherAction)) {
					otherAction = "";
				}
				
				String roleString = (String) xPath.evaluate(String.format("//*[@controller='%s' and (@action='%s' or @action='%s')]/@role", controller, action, otherAction), menuDocument.getDocumentElement(), XPathConstants.STRING);
				Role role = Role.forValue(roleString);
				
				if (role.isAny() || user.getRole().equals(role)) {
					chain.doFilter(request, response);
				} else {
					throw new PermissionException("Permissão negada.");
				}
			} else {
				chain.doFilter(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
