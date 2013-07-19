package br.feevale.physis.converter.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import br.feevale.physis.converter.RequestConverter;
import br.feevale.physis.util.RequestUtils;
import br.feevale.physis.util.StringUtils;

public class GenericRequestConverter<T> implements RequestConverter<T> {

	private Map<String, String> parameters;
	private Class<T> clazz;
	private String var;
	
	private Map<String, Object> properties;
	
	public GenericRequestConverter(HttpServletRequest request, Class<T> clazz) {
		this(request, clazz, StringUtils.uncapitalizeFirst(clazz.getName()));
	}
	
	public GenericRequestConverter(HttpServletRequest request, Class<T> clazz, String var) {
		this(RequestUtils.getRequestParameters(request), clazz, var);
	}
	
	public GenericRequestConverter(Map<String, String> parameters, Class<T> clazz, String var) {
		this.parameters = parameters;
		this.clazz = clazz;
		this.var = var;
		
		mapProperties();
	}

	private void mapProperties() {
		properties = new HashMap<String, Object>();
		
		Set<String> names = parameters.keySet();
		for (String param : names) {
			mapRecursively(properties, param, parameters.get(param));
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private void mapRecursively(Map<String, Object> map, String param, String value) {
		String splited[] = param.split("\\.");
		
		if (splited.length > 1) {
			if (!map.containsKey(splited[0])) {
				map.put(splited[0], new HashMap<String, String>());
			}
			
			mapRecursively((Map<String, Object>) map.get(splited[0]), param.replaceFirst("^[_0-9A-Za-z]*\\.", ""), value);
		} else {
			map.put(param, value);
		}
	}

	@Override
	public T convert() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
