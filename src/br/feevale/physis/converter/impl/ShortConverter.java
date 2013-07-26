package br.feevale.physis.converter.impl;

import java.lang.reflect.Type;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class ShortConverter implements Converter<Short, String> {

	@Override
	public Short convert(Class<Short> returnedClass, String value, Type genericType) {
		if (StringUtils.isNotBlank(value)) {
			return Short.parseShort(value);
		}
		
		return null;
	}

}
