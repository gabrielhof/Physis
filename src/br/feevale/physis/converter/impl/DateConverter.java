package br.feevale.physis.converter.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.util.StringUtils;

public class DateConverter implements Converter<Date, String> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@Override
	public Date convert(Class<Date> returnedClass, String value) {
		try {
			if (StringUtils.isNotBlank(value)) {
				value = value.trim();
				
				if (value.length() == 10) {
					return dateFormat.parse(value);
				} else if (value.length() == 19) {
					return dateTimeFormat.parse(value);
				}
			}
			
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
