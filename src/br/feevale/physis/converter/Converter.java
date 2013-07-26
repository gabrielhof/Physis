package br.feevale.physis.converter;

import java.lang.reflect.Type;

public interface Converter<K, V> {
	
	public K convert(Class<K> returnClass, V value, Type genericType);

}
