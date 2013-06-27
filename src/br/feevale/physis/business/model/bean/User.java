package br.feevale.physis.business.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.feevale.physis.model.Bean;

@Entity
@Table(name="users")
@SuppressWarnings("serial")
public class User extends Bean {

	private Integer id;
	private String username;
	private String password;
	
	@Id @GeneratedValue
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}