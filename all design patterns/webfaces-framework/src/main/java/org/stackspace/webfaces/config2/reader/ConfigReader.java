package org.stackspace.webfaces.config2.reader;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import org.stackspace.webfaces.config2.WebFaces;
import org.stackspace.webfaces.exception.ConfigException;

public class ConfigReader {
	public WebFaces readConfig(String filePath) {
		JAXBContext jContext = null;
		Unmarshaller unmarshaller = null;
		WebFaces webFaces = null;

		try {
			jContext = JAXBContext.newInstance("org.stackspace.webfaces.config2");
			unmarshaller = jContext.createUnmarshaller();
			JAXBElement<WebFaces> jElement = (JAXBElement<WebFaces>) unmarshaller.unmarshal(new File(filePath));
			webFaces = jElement.getValue();
		} catch (Exception e) {
			throw new ConfigException("unable to read web-faces configuration", e);
		}
		return webFaces;
	}
}
