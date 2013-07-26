package br.feevale.physis.converter.impl;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class BigDecimalConverter implements Converter<BigDecimal, String> {

	@Override
	public BigDecimal convert(Class<BigDecimal> returnedClass, String value, Type genericType) {
		if (StringUtils.isNotBlank(value)) {
			return new BigDecimal(value);
		}
		
		return null;
	}

}
