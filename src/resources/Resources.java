package resources;

import java.io.InputStream;

public class Resources {

	public static final String APPLICATION_MENU = "../META-INF/menu.xml";
	
	public static InputStream getResource(String resource) {
		return Resources.class.getResourceAsStream(resource);
	}
	
}
