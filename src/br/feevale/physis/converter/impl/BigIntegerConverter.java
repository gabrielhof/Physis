package br.feevale.physis.converter.impl;

import java.math.BigInteger;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class BigIntegerConverter implements Converter<BigInteger, String>{

	@Override
	public BigInteger convert(Class<BigInteger> returnedClass, String value) {
		if (StringUtils.isNotBlank(value)) {
			return new BigInteger(value);
		}
		
		return null;
	}

}
