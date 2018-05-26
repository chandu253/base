package com.jerseybootstrap.common;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.jerseybootstrap.resource.ProductResource;

@ApplicationPath("/config/*")
public class JerseyBootstrapConfig extends ResourceConfig {
	public JerseyBootstrapConfig() {
		super.register(new ProductResource());
	}

}
