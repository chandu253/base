package org.stackspace.webfaces.config2.manager;

import org.stackspace.webfaces.config2.WebFaces;
import org.stackspace.webfaces.config2.converter.ConfigConverter;
import org.stackspace.webfaces.config2.reader.ConfigReader;
import org.stackspace.webfaces.metadata.WebFacesConfig;

public class WebFacesConfigManager {
	public WebFacesConfig getWebFacesConfig(String filePath) {
		WebFaces webFaces = null;
		ConfigReader configReader = null;
		WebFacesConfig webFacesConfig = null;
		ConfigConverter configConverter = null;

		configReader = new ConfigReader();
		configConverter = new ConfigConverter();

		webFaces = configReader.readConfig(filePath);
		webFacesConfig = configConverter.convert(webFaces);
		return webFacesConfig;
	}
}
