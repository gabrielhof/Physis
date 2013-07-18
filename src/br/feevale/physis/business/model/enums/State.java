package br.feevale.physis.business.model.enums;

import br.feevale.physis.enums.EnumDomain;

public enum State implements EnumDomain {
	
	AC("AC", "Acre"),
	AL("AL", "Alagoas"),
	AP("AP", "Amapá"),
	AM("AM", "Amazonas"),
	BA("BA", "Bahia"),
	CE("CE", "Ceará"),
	DF("DF", "Distrito Federal"),
	ES("ES", "Espírito Santo"),
	GO("GO", "Goiás"),
	MA("MA", "Maranhão"),
	MT("MT", "Mato Grosso"),
	MS("MS", "Mato Grosso do Sul"),
	PA("PA", "Pará"),
	PB("PB", "Paraíba"),
	PR("PR", "Paraná"),
	PE("PE", "Pernambuco"),
	PI("PI", "Piauí"),
	RJ("RJ", "Rio de Janeiro"),
	RN("RN", "Rio Grande do Norte"),
	RS("RS", "Rio Grande do Sul"),
	RO("RO", "Rondônia"),
	RR("RR", "Roraima"),
	SC("SC", "Santa Catarina"),
	SP("SP", "São Paulo"),
	SE("SE", "Sergipe"),
	TO("TO", "Tocantins");

	private String abreviation;
	private String stateName;

	State(String abreviation, String stateName) {
		this.abreviation = abreviation;
		this.stateName = stateName;
	}
	
	@Override
	public String getValue() {
		return abreviation;
	}
	
	@Override
	public String toString() {
		return stateName;
	}

}
