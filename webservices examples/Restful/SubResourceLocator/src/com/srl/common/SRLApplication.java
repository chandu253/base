package com.srl.common;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.srl.resource.SamsungCare;

@ApplicationPath("/api")
public class SRLApplication extends Application {
	private Set<Object> singletons;

	public SRLApplication() {
		singletons = new HashSet();
		singletons.add(new SamsungCare());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
