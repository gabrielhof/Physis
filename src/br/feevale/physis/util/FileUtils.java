package br.feevale.physis.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileUtils {

	public static String readFile(File file) {
		if (file != null && file.exists()) {
			try {
				return readerToString(new FileReader(file));
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
		
		return null;
	}
	
	public static String readStream(InputStream inputStream) {
		return readerToString(new InputStreamReader(inputStream));
		
	}
	
	public static String readerToString(Reader reader) {
		try {
			BufferedReader bufferedReader = null;
			if (reader instanceof BufferedReader) {
				bufferedReader = (BufferedReader) reader;
			} else {
				bufferedReader = new BufferedReader(reader);
			}
			
			String line = null;
			StringBuilder builder = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
				builder.append(line).append("\n");
			}
			
			bufferedReader.close();
			return builder.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
}
