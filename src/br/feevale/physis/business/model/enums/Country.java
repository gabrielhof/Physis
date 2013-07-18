package br.feevale.physis.business.model.enums;

import br.feevale.physis.enums.EnumDomain;

public enum Country implements EnumDomain {
	
	BR("BR", "Brasil");

	private String abreviation;
	private String countryName;
	
	private Country(String abreviation, String countryName) {
		this.abreviation = abreviation;
		this.countryName = countryName;
	}
	
	@Override
	public String getValue() {
		return abreviation;
	}
	
	@Override
	public String toString() {
		return countryName;
	}

}
