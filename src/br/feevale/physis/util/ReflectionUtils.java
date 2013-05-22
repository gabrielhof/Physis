package br.feevale.physis.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
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

}
