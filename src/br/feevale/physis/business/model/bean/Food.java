package br.feevale.physis.business.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.feevale.physis.model.Bean;

@Entity @Table(name="foods")
public class Food extends Bean {

	private static final long serialVersionUID = -4240062157307294484L;
	
	private Integer id;
	private String name;
	
	private Double proteinPercentual;
	private Double carbohydratePercentual;
	private Double fatPercentual;
	
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
	
	@Column(name="protein_percentual", length=4, precision=1)
	public Double getProteinPercentual() {
		return proteinPercentual;
	}
	
	public void setProteinPercentual(Double proteinPercentual) {
		this.proteinPercentual = proteinPercentual;
	}
	
	@Column(name="carbohydrate_percentual", length=4, precision=1)
	public Double getCarbohydratePercentual() {
		return carbohydratePercentual;
	}
	
	public void setCarbohydratePercentual(Double carbohydratePercentual) {
		this.carbohydratePercentual = carbohydratePercentual;
	}
	
	@Column(name="fat_percentual", length=4, precision=1)
	public Double getFatPercentual() {
		return fatPercentual;
	}
	
	public void setFatPercentual(Double fatPercentual) {
		this.fatPercentual = fatPercentual;
	}
	
	@Override
	public String toUserString() {
		return getName();
	}

}
