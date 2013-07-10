package br.feevale.physis.business.model.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import br.feevale.physis.business.model.enums.Role;
import br.feevale.physis.model.Bean;

@XmlRootElement
public class Menu extends Bean {

	private static final long serialVersionUID = -6209978512083996069L;
	
	private String name;
	private String controller;
	private String action;
	
	private Role role;
	
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
		this.role = role;
	}
	
	@XmlElementWrapper(name="menus")
	@XmlElement(name="menu")
	public List<Menu> getMenus() {
		return menus;
	}
	
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
}