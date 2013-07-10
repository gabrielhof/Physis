package br.feevale.physis.business.model.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="role")
@XmlEnum
public enum Role {
	
	@XmlEnumValue("ADMIN")
	ADMIN,
	@XmlEnumValue("PROFESSOR")
	PROFESSOR,
	@XmlEnumValue("USER")
	USER;

}
