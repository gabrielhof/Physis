package br.feevale.physis.converter.impl;

import java.lang.reflect.Type;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class IntegerConverter implements Converter<Integer, String> {

	@Override
	public Integer convert(Class<Integer> returnedClass, String value, Type genericType) {
		if (StringUtils.isNotBlank(value)) {
			return Integer.parseInt(value);
		}
		
		return null;
	}


}
