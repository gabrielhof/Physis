package br.feevale.physis.converter.impl;

import br.feevale.physis.converter.Converter;

public class StringConverter implements Converter<String, String> {

	@Override
	public String convert(Class<String> returnedClass, String value) {
		return value;
	}

}
