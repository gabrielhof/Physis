package br.feevale.physis.business.model.bean;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.feevale.physis.business.model.enums.Country;
import br.feevale.physis.business.model.enums.State;
import br.feevale.physis.model.Bean;

@Entity @Table(name="addresses")
public class Address extends Bean {

	private static final long serialVersionUID = -8307641937378824798L;
	
	private Integer id;
	private String cep;
	private String address;
	private Integer number;
	private String complement;
	private String district;
	private String city;
	private State state;
	private Country country;
	
	private Person person;
	
	@Id @GeneratedValue @Override
	public Integer getId() {
		return id;
	}	
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	@Enumerated(EnumType.STRING)
	public void setState(State state) {
		this.state = state;
	}
	
	@Enumerated(EnumType.STRING)
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@OneToOne
	@JoinColumn(name="person_id")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toUserString() {
		return address;
	}

}
