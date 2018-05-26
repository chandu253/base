package com.adi.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.adi.config.MvcConfig;
import com.adi.config.RootConfig;

public class JavaConfigAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootApplicationContext = null;
		AnnotationConfigWebApplicationContext servletApplicationContext = null;
		ContextLoaderListener contextLoaderListener = null;
		DispatcherServlet dispatcher = null;

		rootApplicationContext = new AnnotationConfigWebApplicationContext();
		rootApplicationContext.register(RootConfig.class);
		contextLoaderListener = new ContextLoaderListener(rootApplicationContext);
		servletContext.addListener(contextLoaderListener);

		servletApplicationContext = new AnnotationConfigWebApplicationContext();
		servletApplicationContext.register(MvcConfig.class);
		dispatcher = new DispatcherServlet(servletApplicationContext);
		ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", dispatcher);
		dynamic.setLoadOnStartup(2);
		dynamic.addMapping("*.htm");

	}

}
