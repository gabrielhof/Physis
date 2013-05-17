package org.teste.util;

public class DecimalUtils {

	public static Double parseDouble(String s) {
		if (StringUtils.isNotBlank(s)) {
			try {
				return Double.parseDouble(s);
			} catch (Exception e) {}
		}
		
		return null; 
	}
	
}
