package br.feevale.physis.converter.impl;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class DoubleConverter implements Converter<Double, String> {

	@Override
	public Double convert(Class<Double> returnedClass, String value) {
		if (StringUtils.isNotBlank(value)) {
			return Double.parseDouble(value);
		}
		
		return null;
	}

}
