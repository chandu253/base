package com.cw.common;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;

import com.cw.resource.AmazonTransportService;

@ApplicationPath("/api")
public class CacheApplication extends ResourceConfig {

	public CacheApplication() {
		register(new AmazonTransportService());
	}

}
