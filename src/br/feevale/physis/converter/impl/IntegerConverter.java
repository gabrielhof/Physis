package br.feevale.physis.converter.impl;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class IntegerConverter implements Converter<Integer, String> {

	@Override
	public Integer convert(Class<Integer> returnedClass, String value) {
		if (StringUtils.isNotBlank(value)) {
			return Integer.parseInt(value);
		}
		
		return null;
	}


}
