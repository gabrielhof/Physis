package br.feevale.physis.converter.impl;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class FloatConverter implements Converter<Float, String> {

	@Override
	public Float convert(Class<Float> returnedClass, String value) {
		if (StringUtils.isNotBlank(value)) {
			return Float.parseFloat(value);
		}
		
		return null;
	}

}
