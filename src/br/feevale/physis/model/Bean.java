package br.feevale.physis.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class Bean implements Serializable {

	private static final long serialVersionUID = 1996182945173084373L;
	
	public abstract Integer getId();
	
	public abstract String toUserString();
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (obj.getClass() != getClass()) {
			return false;
		}

		return obj.hashCode() == hashCode();
	}
	
	public int hashCode() {
		int hashCode = 1;
		
		Field fields[] = getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				if (Modifier.isStatic(field.getModifiers())) {
					if (!field.isAccessible()) {
						field.setAccessible(true);
					}
					
					Object value = field.get(this);
					hashCode = 29 * (hashCode + (value == null ? 0 : value.hashCode()));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return hashCode;
	}
	
	@Override
	public String toString() {
		Field fields[] = getClass().getDeclaredFields();
		
		StringBuilder builder = new StringBuilder();
		builder.append(getClass()).append("[\n");
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			try {
				if (!Modifier.isStatic(field.getModifiers())) {
					if (!field.isAccessible()) {
						field.setAccessible(true);
					}
					
					Object value = field.get(this);
					
					builder.append("	");
					builder.append(field.getName()).append("=");
					
					if (value instanceof Bean) {
						builder.append(String.format("%s@%s", value.getClass().getName(), value.hashCode()));
					} else if (value != null) {
						builder.append(value);
					} else {
						builder.append("null");
					}
					
					if (i < (fields.length-1)) {
						builder.append(",\n");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		builder.append("]\n");
		return builder.toString();
	}
	
}
