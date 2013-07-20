package br.feevale.physis.converter.impl;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class LongConverter implements Converter<Long, String>{

	@Override
	public Long convert(Class<Long> returnedClass, String value) {
		if (StringUtils.isNotBlank(value)) {
			return Long.parseLong(value);
		}
		
		return null;
	}

}
