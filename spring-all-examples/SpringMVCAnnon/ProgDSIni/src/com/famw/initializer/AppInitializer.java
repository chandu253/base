package com.famw.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		XmlWebApplicationContext webApplicationContext = null;
		DispatcherServlet dispatcher = null;

		// create web application ioc container
		webApplicationContext = new XmlWebApplicationContext();
		webApplicationContext.setConfigLocation("/WEB-INF/dispatcher-servlet.xml");

		dispatcher = new DispatcherServlet(webApplicationContext);
		Dynamic dynamic = servletContext.addServlet("dispatcher", dispatcher);
		dynamic.setLoadOnStartup(1);
		dynamic.addMapping("*.htm");
	}

}
