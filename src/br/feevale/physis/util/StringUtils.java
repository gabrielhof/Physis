package br.feevale.physis.util;

public final class StringUtils {

	public static boolean isBlank(String s) {
		return s == null || s.trim().length() == 0;
	}
	
	public static boolean isNotBlank(String s) {
		return !isBlank(s);
	}
	
	public static String capitalizeFirst(String s) {
		if (isNotBlank(s)) {
			s = s.trim();
			s = s.substring(0, 1).toUpperCase() + s.substring(1);
		}
		
		return s;
	}
	
	public static String uncapitalizeFirst(String s) {
		if (isNotBlank(s)) {
			s = s.trim();
			s = s.substring(0, 1).toLowerCase() + s.substring(1);
		}
		
		return s;
	}
}
