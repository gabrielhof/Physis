package br.feevale.physis.business.model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.feevale.physis.model.Bean;

@Entity @Table(name="evaluation")
public class Evaluation extends Bean {

	private static final long serialVersionUID = -845706413713350506L;
	
	private Integer id;
	private Date date;
	private Double weight;
	private Integer height;
	private Double percentualLeanMass;
	private Double percentualFatMass;
	
	private Person professor;
	private Person user;
	
	private Training training;
	
	@Id @GeneratedValue @Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Double getPercentualLeanMass() {
		return percentualLeanMass;
	}

	public void setPercentualLeanMass(Double percentualLeanMass) {
		this.percentualLeanMass = percentualLeanMass;
	}

	public Double getPercentualFatMass() {
		return percentualFatMass;
	}

	public void setPercentualFatMass(Double percentualFatMass) {
		this.percentualFatMass = percentualFatMass;
	}

	@ManyToOne @JoinColumn(name="professor_id", nullable=false)
	public Person getProfessor() {
		return professor;
	}

	public void setProfessor(Person professor) {
		this.professor = professor;
	}

	@ManyToOne @JoinColumn(name="user_id", nullable=false)
	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

	@ManyToOne @JoinColumn(name="training_id", nullable=true)
	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	@Override
	public String toUserString() {
		String user = getUser() == null ? "" : getUser().toUserString();
		String date = getDate() == null ? "" : getDate().toString();
		
		return String.format("%s - %s", user, date);
	}

}
