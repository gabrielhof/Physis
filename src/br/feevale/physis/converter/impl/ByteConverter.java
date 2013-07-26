package br.feevale.physis.converter.impl;

import java.lang.reflect.Type;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class ByteConverter implements Converter<Byte, String> {

	@Override
	public Byte convert(Class<Byte> returnedClass, String value, Type genericType) {
		if (StringUtils.isNotBlank(value)) {
			return Byte.parseByte(value);
		}
		
		return null;
	}

}
