package br.feevale.physis.converter.impl;

import java.lang.reflect.Type;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class FloatConverter implements Converter<Float, String> {

	@Override
	public Float convert(Class<Float> returnedClass, String value, Type genericType) {
		if (StringUtils.isNotBlank(value)) {
			return Float.parseFloat(value);
		}
		
		return null;
	}

}
