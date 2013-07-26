package br.feevale.physis.converter.impl;

import java.lang.reflect.Type;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class LongConverter implements Converter<Long, String>{

	@Override
	public Long convert(Class<Long> returnedClass, String value, Type genericType) {
		if (StringUtils.isNotBlank(value)) {
			return Long.parseLong(value);
		}
		
		return null;
	}

}
