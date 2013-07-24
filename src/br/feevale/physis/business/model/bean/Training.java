package br.feevale.physis.business.model.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ManyToAny;

import br.feevale.physis.model.Bean;

public class Training extends Bean {

	private static final long serialVersionUID = -4290520646265463545L;
	
	private Integer id;
	private String name;
	
	private List<Exercise> exercises;

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

	public List<Exercise> getExercises() {
		return exercises;
	}
	
	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
	
	@Override
	public String toUserString() {
		return null;
	}

}
