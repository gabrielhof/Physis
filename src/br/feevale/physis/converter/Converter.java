package br.feevale.physis.converter;

public interface Converter<K, V> {
	
	public K convert(Class<K> returnClass, V value);

}
