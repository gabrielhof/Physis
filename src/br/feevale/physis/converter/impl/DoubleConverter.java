package br.feevale.physis.converter.impl;

import java.lang.reflect.Type;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class DoubleConverter implements Converter<Double, String> {

	@Override
	public Double convert(Class<Double> returnedClass, String value, Type genericType) {
		if (StringUtils.isNotBlank(value)) {
			return Double.parseDouble(value.replace(",", "."));
		}
		
		return null;
	}

}
