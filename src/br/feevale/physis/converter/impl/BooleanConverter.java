package br.feevale.physis.converter.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class BooleanConverter implements Converter<Boolean, String> {

	private List<String> trueValues;
	private List<String> falseValues;
	
	public BooleanConverter() {
		trueValues = new ArrayList<String>();
		trueValues.add("true");
		trueValues.add("1");
		trueValues.add("s");
		trueValues.add("y");
		trueValues.add("sim");
		trueValues.add("yes");
		
		falseValues = new ArrayList<String>();
		falseValues.add("false");
		falseValues.add("0");
		falseValues.add("n");
		falseValues.add("no");
		falseValues.add("nao");
	}
	
	@Override
	public Boolean convert(Class<Boolean> returnedClass, String value, Type genericType) {
		if (StringUtils.isNotBlank(value)) {
			value = value.trim().toLowerCase();
			
			if (trueValues.contains(value)) {
				return true;
			} else if (falseValues.contains(value)) {
				return false;
			}
		}
		
		return null;
	}

}
