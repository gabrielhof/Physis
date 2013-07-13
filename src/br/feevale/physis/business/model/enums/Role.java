package br.feevale.physis.business.model.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import br.feevale.physis.enums.EnumDomain;

@XmlType(name="role")
@XmlEnum
public enum Role implements EnumDomain {
	
	@XmlEnumValue("ADMIN")
	ADMIN("ADMIN", "Admin", false),
	@XmlEnumValue("PROFESSOR")
	PROFESSOR("PROFESSOR", "Professor", false),
	@XmlEnumValue("USER")
	USER("USER", "Usuario", false),
	@XmlEnumValue("ANY")
	ANY("ANY", "Qualquer", true);

	private String value;
	private String meaning;
	private boolean any;
	
	Role(String value, String meaning, boolean any) {
		this.value = value;
		this.meaning = meaning;
		
		this.any = any;
	}
	
	@Override
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return meaning;
	}
	
	public boolean isAny() {
		return any;
	}
	
	public static Role forValue(String value) {
		for (Role role : values()) {
			if (role.getValue().equalsIgnoreCase(value)) {
				return role;
			}
		}
		
		return Role.ANY;
	}

}
