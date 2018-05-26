package org.stackspace.webfaces.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.stackspace.webfaces.config2.manager.WebFacesConfigManager;
import org.stackspace.webfaces.metadata.WebFacesConfig;
import org.stackspace.webfaces.processor.WebFacesApplicationProcessor;

public class WebFaces2Servlet extends HttpServlet {
	private final String WEBFACES_CONFIG_FILE = "web-faces.xml";
	private WebFacesConfig webFacesConfig;
	private WebFacesApplicationProcessor webFacesApplicationProcessor;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String realPath = null;
		ServletContext context = null;
		WebFacesConfigManager configManager = null;

		context = config.getServletContext();
		realPath = context.getRealPath("/");
		configManager = new WebFacesConfigManager();
		webFacesConfig = configManager.getWebFacesConfig(realPath + "/WEB-INF/" + WEBFACES_CONFIG_FILE);
		webFacesApplicationProcessor = new WebFacesApplicationProcessor();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		webFacesApplicationProcessor.process(request, response, webFacesConfig);
	}

}
