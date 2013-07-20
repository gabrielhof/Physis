package br.feevale.physis.converter.impl;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class ByteConverter implements Converter<Byte, String> {

	@Override
	public Byte convert(Class<Byte> returnedClass, String value) {
		if (StringUtils.isNotBlank(value)) {
			return Byte.parseByte(value);
		}
		
		return null;
	}

}
