package br.feevale.physis.converter.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.enums.Converters;
import br.feevale.physis.model.Bean;
import br.feevale.physis.util.ReflectionUtils;

public class BeanConverter implements Converter<Bean, Map<String, Object>> {

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Bean convert(Class<Bean> returnClass, Map<String, Object> parameters) {
		try {
			Field fields[] = returnClass.getDeclaredFields();
			Bean beanInstance = returnClass.newInstance();
			
			for (Field field : fields) {
				if (!Modifier.isStatic(field.getModifiers()) && parameters.containsKey(field.getName())) {
					Converter converter = Converters.forClass(field.getType()).getConverter();
					Object value = converter.convert(field.getType(), parameters.get(field.getName()));
					
					ReflectionUtils.setProperty(field.getName(), value, beanInstance);
				}
			}
			
			return beanInstance;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}