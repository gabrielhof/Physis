package br.feevale.physis.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resources.Resources;
import br.feevale.physis.business.model.bean.Menu;
import br.feevale.physis.util.MetadataUtils;

public class Teste extends HttpServlet {

	private static final long serialVersionUID = 499158557567213510L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream in = Resources.getResource(Resources.APPLICATION_MENU);
		Menu menu = MetadataUtils.fromXmlToObject(in, Menu.class);
		
		response.getWriter().write(menu.toString());
	}
	
	protected void testToObject(HttpServletResponse response) throws IOException {
		Menu pai = new Menu();
		pai.setName("Pai");
		pai.setController("ControllerPai");
		pai.setAction("ActionPai");
		pai.setMenus(new ArrayList<Menu>());
		
		Menu outroPai = new Menu();
		outroPai.setName("OutroPai");
		outroPai.setController("ControllerOutroPai");
		outroPai.setAction("ActionOutroPai");
		outroPai.setMenus(new ArrayList<Menu>());
		
		Menu avo = new Menu();
		avo.setName("Avo");
		avo.setController("ControllerAvo");
		avo.setAction("ActionAvo");
		avo.setMenus(new ArrayList<Menu>());
		avo.getMenus().add(pai);
		avo.getMenus().add(outroPai);
		
		String xml = MetadataUtils.fromObjectToXml(avo);
		
		response.setContentType("application/xml");
		response.getWriter().write(xml);
	}

}
