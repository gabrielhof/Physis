package br.feevale.physis.business.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.feevale.physis.model.Bean;

@Entity
@Table(name="people")
public class Person extends Bean {

	private static final long serialVersionUID = 5244070687230420960L;
	
	private Integer id;
	private String name;
	private Integer age;
	
	@Id
	@GeneratedValue
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
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
}