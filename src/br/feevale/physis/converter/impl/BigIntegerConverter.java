package br.feevale.physis.converter.impl;

import java.lang.reflect.Type;
import java.math.BigInteger;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class BigIntegerConverter implements Converter<BigInteger, String>{

	@Override
	public BigInteger convert(Class<BigInteger> returnedClass, String value, Type genericType) {
		if (StringUtils.isNotBlank(value)) {
			return new BigInteger(value);
		}
		
		return null;
	}

}
