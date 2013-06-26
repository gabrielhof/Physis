package br.feevale.physis.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class EncryptpUtils {
	
	public static String md5(String s) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(s.getBytes("UTF-8"));
			return new BigInteger(1, md5.digest()).toString(16);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
