package br.feevale.physis.business.model.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.feevale.physis.model.Bean;

@Entity @Table(name="training")
public class Training extends Bean {

	private static final long serialVersionUID = -4290520646265463545L;
	
	private Integer id;
	private String name;
	
	private List<TrainingExercise> trainingExercises;

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

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="training", orphanRemoval=true)
	public List<TrainingExercise> getTrainingExercises() {
		return trainingExercises;
	}
	
	public void setTrainingExercises(List<TrainingExercise> trainingExercises) {
		this.trainingExercises = trainingExercises;
	}
	
	@Override
	public String toUserString() {
		return getName();
	}

}
