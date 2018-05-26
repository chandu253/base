package com.qdm.initializer;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class AppInitializer extends AbstractDispatcherServletInitializer {

	@Override
	protected WebApplicationContext createServletApplicationContext() {
		XmlWebApplicationContext servletApplicationContext = null;

		servletApplicationContext = new XmlWebApplicationContext();
		servletApplicationContext.setConfigLocation("/WEB-INF/web-beans.xml");

		return servletApplicationContext;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "*.action" };
	}

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		XmlWebApplicationContext rootApplicationContext = null;
		rootApplicationContext = new XmlWebApplicationContext();
		rootApplicationContext.setConfigLocation("/WEB-INF/root-application-context.xml");
		return rootApplicationContext;
	}

}
