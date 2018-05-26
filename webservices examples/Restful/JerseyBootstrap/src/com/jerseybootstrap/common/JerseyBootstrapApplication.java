package com.jerseybootstrap.common;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.jerseybootstrap.resource.ProductResource;

/*@ApplicationPath("/api/*")*/
public class JerseyBootstrapApplication extends Application {
	protected Set<Object> singletons;

	public JerseyBootstrapApplication() {
		System.out.println("JerseyBootstrapApplication()");
		singletons = new HashSet<>();
		singletons.add(new ProductResource());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
