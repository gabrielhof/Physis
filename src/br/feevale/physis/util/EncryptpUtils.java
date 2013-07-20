package br.feevale.physis.util;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

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
	
	public static String base64Encode(String s) {
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(s.getBytes());
	}
	
	public static String base64Decode(String s) {
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			return new String(decoder.decodeBuffer(s));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	

}
