package br.feevale.physis.converter.impl;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class ShortConverter implements Converter<Short, String> {

	@Override
	public Short convert(Class<Short> returnedClass, String value) {
		if (StringUtils.isNotBlank(value)) {
			return Short.parseShort(value);
		}
		
		return null;
	}

}
