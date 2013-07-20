package br.feevale.physis.converter.impl;

import java.math.BigDecimal;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class BigDecimalConverter implements Converter<BigDecimal, String> {

	@Override
	public BigDecimal convert(Class<BigDecimal> returnedClass, String value) {
		if (StringUtils.isNotBlank(value)) {
			return new BigDecimal(value);
		}
		
		return null;
	}

}
