package br.feevale.physis.business.model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.feevale.physis.model.Bean;

@Entity @Table(name="training_exercises")
public class TrainingExercise extends Bean {

	private static final long serialVersionUID = 2416035173721414121L;
	
	private Integer id;
	private Integer series;
	private Integer repetitions;
	private Integer weight;
	
	private Training training;
	private Exercise exercise;
	
	@Id @GeneratedValue @Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getSeries() {
		return series;
	}

	public void setSeries(Integer series) {
		this.series = series;
	}

	public Integer getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(Integer repetitions) {
		this.repetitions = repetitions;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	@ManyToOne(cascade=CascadeType.ALL) @JoinColumn(name="training_id", nullable=false)
	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	@ManyToOne @JoinColumn(name="exercise_id", nullable=false)
	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	@Override
	public String toUserString() {
		String training = getTraining() == null ? "" : getTraining().toString();
		String exercise = getExercise() == null ? "" : getExercise().toString();
		
		return String.format("%s - %s", training, exercise);
	}

	
	
}
