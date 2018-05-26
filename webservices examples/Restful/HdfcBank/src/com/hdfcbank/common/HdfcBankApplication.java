package com.hdfcbank.common;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import com.hdfcbank.resource.AccountService;

public class HdfcBankApplication extends ResourceConfig {

	public HdfcBankApplication() {
		register(AccountService.class);
		register(RolesAllowedDynamicFeature.class);
	}

}
