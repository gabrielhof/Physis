package br.feevale.physis.converter.impl;

import java.lang.reflect.Type;

import br.feevale.physis.converter.Converter;

public class StringConverter implements Converter<String, String> {

	@Override
	public String convert(Class<String> returnedClass, String value, Type genericType) {
		return value;
	}

}
