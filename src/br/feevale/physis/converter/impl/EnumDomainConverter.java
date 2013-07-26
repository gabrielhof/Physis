package br.feevale.physis.converter.impl;

import java.lang.reflect.Type;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.enums.EnumDomain;

public class EnumDomainConverter implements Converter<EnumDomain, String>{

	@Override
	public EnumDomain convert(Class<EnumDomain> returnedClass, String value, Type genericType) {
		for (EnumDomain domain : returnedClass.getEnumConstants()) {
			if (domain.getValue().equals(value)) {
				return domain;
			}
		}
		
		return null;
	}

}
