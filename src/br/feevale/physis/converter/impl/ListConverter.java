package br.feevale.physis.converter.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.enums.Converters;
import br.feevale.physis.util.CollectionUtils;
import br.feevale.physis.util.StringUtils;

public class ListConverter implements Converter<List<?>, Map<String, Object>>{

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<?> convert(Class<List<?>> returnClass, Map<String, Object> value, Type genericType) {
		if (genericType instanceof ParameterizedType) {
			Class<?> type = (Class<?>) ((ParameterizedType) genericType).getActualTypeArguments()[0];
			
			String variableName = StringUtils.uncapitalizeFirst(type.getSimpleName());
			List<?> transformed = transform(value.get(variableName));

			if (CollectionUtils.isNotEmpty(transformed)) {
				List<Object> result = new ArrayList<Object>();
				
				Converter converter = Converters.forClass(type).getConverter();
				for (Object object : transformed) {
					Object o = converter.convert(type, object, null);
					result.add(o);
				}
				
				return result;
			}
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	protected List<?> transform(Object o) {
		if (o != null) {
			if (o instanceof Map) {
				Map<String, Object> map = (Map<String, Object>) o;
				return mapToList(map);
			} else if (o.getClass().isArray()) {
				return Arrays.asList((String[]) o);
			} else {
				return Arrays.asList(o);
			}
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	protected List<Map<String, Object>> mapToList(Map<String, Object> map) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); 
		
		for (String key : map.keySet()) {
			Object value = map.get(key);
			
			if (value != null) {
				if (value instanceof String) {
					value = new String[] {(String) value};
				}
				
				if (value.getClass().isArray()) {
					String[] arrayValue = (String[]) value;
					for (int i = 0; i < arrayValue.length; i++) {
						if (list.size() <= i) {
							list.add(new HashMap<String, Object>());
						}
						
						list.get(i).put(key, arrayValue[i]);
					}
				} else if (value instanceof Map) {
					List<Map<String, Object>> subMap = mapToList((Map<String, Object>) value);
					for (int i = 0; i < subMap.size(); i++) {
						if (list.size() <= i) {
							list.add(new HashMap<String, Object>());
						}
						
						list.get(i).put(key, subMap.get(i));
					}
				}
			}
		}
		
		return list;
	}

}
