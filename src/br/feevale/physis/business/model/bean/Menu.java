package br.feevale.physis.business.model.bean;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import br.feevale.physis.business.model.enums.Role;
import br.feevale.physis.util.StringUtils;

@XmlRootElement
public class Menu implements Serializable {

	private static final long serialVersionUID = -6209978512083996069L;
	
	private String name;
	private String controller;
	private String action;
	
	private Role role = Role.ANY;
	
	private List<Menu> menus;
	
	@XmlAttribute
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlAttribute
	public String getController() {
		return controller;
	}
	
	public void setController(String controller) {
		this.controller = controller;
	}
	
	@XmlAttribute
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	@XmlAttribute
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		if (role != null) {
			this.role = role;
		}
	}
	
	@XmlElementWrapper(name="menus")
	@XmlElement(name="menu")
	public List<Menu> getMenus() {
		return menus;
	}
	
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
	public String getUrl() {
		StringBuilder url = new StringBuilder();
		if (StringUtils.isNotBlank(getController())) {
			url.append(StringUtils.uncapitalizeFirst(getController())).append("/");
		}
		
		if (StringUtils.isNotBlank(getAction())) {
			url.append(StringUtils.uncapitalizeFirst(getAction())).append("/");
		}
		
		return url.toString();
	}
}