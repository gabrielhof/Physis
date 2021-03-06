package br.feevale.physis.util;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.codehaus.jackson.map.ObjectMapper;

public class MetadataUtils {

	private static final ObjectMapper mapper = new ObjectMapper();
	
	public static String fromObjectToXml(Object o) {
		try {
			File file = File.createTempFile("jaxb_temp_xml_", ".xml");
			
			JAXBContext context = JAXBContext.newInstance(o.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			marshaller.marshal(o, file);
			
			String xml = FileUtils.readFile(file);
			file.delete();
			
			return xml;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> T fromXmlToObject(InputStream in, Class<T> clazz) {
		return fromXmlToObject((Object) in, clazz);
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T fromXmlToObject(Object someInput, Class<T> clazz) {
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			T o = null;
			
			if (someInput instanceof InputStream) {
				o = (T) unmarshaller.unmarshal((InputStream) someInput);
				((InputStream) someInput).close();
			} else if (someInput instanceof Reader) {
				o = (T) unmarshaller.unmarshal((Reader) someInput);
				((Reader) someInput).close();
			} else {
				//TODO
			}
			
			return o;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String fromObjecToJson(Object something) {
		try {
			return mapper.writeValueAsString(something);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
