package com.pmic.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	/**
	 * Register ContextLoaderListener and Dispatcher Servlet
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		XmlWebApplicationContext rootContext = null;
		XmlWebApplicationContext webContext = null;
		ContextLoaderListener contextLoaderListener = null;
		DispatcherServlet dispatcher = null;

		// listener registration
		rootContext = new XmlWebApplicationContext();
		rootContext.setConfigLocation("/WEB-INF/application-context.xml");
		contextLoaderListener = new ContextLoaderListener(rootContext);
		servletContext.addListener(contextLoaderListener);

		// dispatcher servlet registration
		webContext = new XmlWebApplicationContext();
		webContext.setConfigLocation("/WEB-INF/dispatcher-servlet.xml");
		dispatcher = new DispatcherServlet(webContext);
		ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", dispatcher);
		dynamic.setLoadOnStartup(2);
		dynamic.addMapping("*.htm");

	}

}
