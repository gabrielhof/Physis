package br.feevale.physis.enums;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.feevale.physis.converter.Converter;
import br.feevale.physis.converter.impl.BeanConverter;
import br.feevale.physis.converter.impl.BigDecimalConverter;
import br.feevale.physis.converter.impl.BigIntegerConverter;
import br.feevale.physis.converter.impl.BooleanConverter;
import br.feevale.physis.converter.impl.ByteConverter;
import br.feevale.physis.converter.impl.DateConverter;
import br.feevale.physis.converter.impl.DoubleConverter;
import br.feevale.physis.converter.impl.EnumDomainConverter;
import br.feevale.physis.converter.impl.FloatConverter;
import br.feevale.physis.converter.impl.IntegerConverter;
import br.feevale.physis.converter.impl.LongConverter;
import br.feevale.physis.converter.impl.ShortConverter;
import br.feevale.physis.converter.impl.StringConverter;
import br.feevale.physis.model.Bean;

public enum Converters {
	
	BYTE(Byte.class, new ByteConverter()),
	SHORT(Short.class, new ShortConverter()),
	INTEGER(Integer.class, new IntegerConverter()),
	LONG(Long.class, new LongConverter()),
	FLOAT(Float.class, new FloatConverter()),
	DOUBLE(Double.class, new DoubleConverter()),
	BIG_INTEGER(BigInteger.class, new BigIntegerConverter()),
	BIG_DECIMAL(BigDecimal.class, new BigDecimalConverter()),
	BOOLEAN(Boolean.class, new BooleanConverter()),
	DATE(Date.class, new DateConverter()),
	STRING(String.class, new StringConverter()),
	ENUM_DOMAIN(EnumDomain.class, new EnumDomainConverter()),
	BEAN(Bean.class, new BeanConverter()),
	;
	
	private static Map<Class<?>, Converters> extraConverters = new HashMap<Class<?>, Converters>();
	
	private Class<?> clazz;
	private Converter<?, ?> converter;
	
	Converters(Class<?> clazz, Converter<?, ?> conveter) {
		this.clazz = clazz;
		this.converter = conveter;
	}
	
	public Class<?> getClazz() {
		return clazz;
	}
	
	public Converter<?, ?> getConverter() {
		return converter;
	}
	
	public static Converters forClass(Class<?> clazz) {
		if (clazz == null || clazz == Object.class) {
			return null;
		}
		
		if (extraConverters.containsKey(clazz)) {
			return extraConverters.get(clazz);
		} else {
			Converters conv = null;
			
			for (Converters c : values()) {
				if (c.getClazz().equals(clazz)) {
					conv = c;
					break;
				}
			}
			
			if (conv == null) {
				conv = forClass(clazz.getSuperclass());
				if (conv == null) {
					Class<?> interfaces[] = clazz.getInterfaces();
					if (interfaces != null) {
						for (Class<?> inter : interfaces) {
							conv = forClass(inter);
							if (conv != null) {
								break;
							}
						}
					}
				}
			}
			
			extraConverters.put(clazz, conv);
			return conv;
		}
		
	}
}
