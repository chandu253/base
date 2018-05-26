package com.netbanking.common;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.netbanking.resource.Netbanking;

@ApplicationPath("/secure")
public class NetbankingApplication extends ResourceConfig {

	public NetbankingApplication() {
		// singleton
		register(Netbanking.class);
	}

}
