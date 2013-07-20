package br.feevale.physis.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtils {
	
	public static Field[] getAnnotatedFields(Class<?> clazz, Class<? extends Annotation> annotation) {
		List<Field> annotatedFields = new ArrayList<Field>();
		
		for (Field field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(annotation)) {
				annotatedFields.add(field);
			}
		}
		
		
		return CollectionUtils.isEmpty(annotatedFields) ? null : annotatedFields.toArray(new Field[annotatedFields.size()]);
	}

	public static Method getSetter(String propertyName, Class<?> parameterClass, Class<?> clazz) {
		try {
			String setter = StringUtils.capitalizeFirst(propertyName);
			setter = String.format("set%s", setter);
			
			if (parameterClass != null) {
				return clazz.getDeclaredMethod(setter, parameterClass);
			} else {
				Method methods[] = clazz.getDeclaredMethods();
				for (Method method : methods) {
					if (method.getName().equals(setter)) {
						return method;
					}
				}
			}
			
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void setProperty(String propertyName, Class<?> propertyType, Object value, Object classInstance) {
		Method setter = getSetter(propertyName, propertyType, classInstance.getClass());
		
		try {
			setter.invoke(classInstance, value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
