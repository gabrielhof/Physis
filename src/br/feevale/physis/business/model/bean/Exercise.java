package br.feevale.physis.business.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.feevale.physis.model.Bean;

@Entity @Table(name="exercises")
public class Exercise extends Bean {

	private static final long serialVersionUID = 4879577173191763725L;

	private Integer id;
	private String name;
	private String description;
	
	private Equipment equipment;
	
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
	
	@ManyToOne @JoinColumn(name="equipment_id", nullable=true, updatable=true)
	public Equipment getEquipment() {
		return equipment;
	}
	
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public String toUserString() {
		return getName();
	}

}
