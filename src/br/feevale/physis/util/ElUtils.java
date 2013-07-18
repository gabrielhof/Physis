package br.feevale.physis.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.feevale.physis.enums.EnumDomain;

public class ElUtils {

	@SuppressWarnings("unchecked")
	public static <T extends EnumDomain> List<T> getEnumValues(String enumClass) {
		try {
			Class<T> clazz = (Class<T>) Class.forName(enumClass);
			return new ArrayList<T>(Arrays.asList(clazz.getEnumConstants()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
