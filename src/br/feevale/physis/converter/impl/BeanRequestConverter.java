package br.feevale.physis.converter.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.converter.RequestConverter;
import br.feevale.physis.enums.Converters;
import br.feevale.physis.model.Bean;
import br.feevale.physis.util.RequestUtils;
import br.feevale.physis.util.StringUtils;

public class BeanRequestConverter<T extends Bean> implements RequestConverter<T> {

	private Class<T> clazz;
	private String var;
	
	private Map<String, Object> properties;
	
	public BeanRequestConverter(HttpServletRequest request, Class<T> clazz) {
		this(request, clazz, StringUtils.uncapitalizeFirst(clazz.getSimpleName()));
	}
	
	public BeanRequestConverter(HttpServletRequest request, Class<T> clazz, String var) {
		this(RequestUtils.getRequestParameters(request), clazz, var);
	}
	
	public BeanRequestConverter(Map<String, String[]> parameters, Class<T> clazz, String var) {
		this.clazz = clazz;
		this.var = var;
		
		mapProperties(parameters);
	}

	private void mapProperties(Map<String, String[]> parameters) {
		properties = new HashMap<String, Object>();
		
		Set<String> names = parameters.keySet();
		for (String param : names) {
			mapRecursively(properties, param, parameters.get(param));
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private void mapRecursively(Map<String, Object> map, String param, String[] value) {
		String splited[] = param.split("\\.");
		
		if (splited.length > 1) {
			if (!map.containsKey(splited[0])) {
				map.put(splited[0], new HashMap<String, String>());
			}
			
			mapRecursively((Map<String, Object>) map.get(splited[0]), param.replaceFirst("^[_0-9A-Za-z]*\\.", ""), value);
		} else {
			if (value.length == 1) {
				map.put(param, value[0]);
			} else if (value.length > 1) {
				map.put(param, value);
			}
		}
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public T convert() {
		Converter converter = Converters.BEAN.getConverter();
		return (T) converter.convert(clazz, properties.get(var), null);
	}
	
}
