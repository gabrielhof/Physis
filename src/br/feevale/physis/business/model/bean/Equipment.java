package br.feevale.physis.business.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.feevale.physis.model.Bean;

@Entity @Table(name="equipments")
public class Equipment extends Bean {

	private static final long serialVersionUID = -973510025780349760L;

	private Integer id;
	private String name;
	private String description;
	
	@Id @GeneratedValue @Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toUserString() {
		return getName();
	}

}
