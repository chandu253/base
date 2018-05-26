package com.sri.initiator;

import java.util.Map;

import org.hibernate.boot.registry.StandardServiceInitiator;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.service.spi.ServiceRegistryImplementor;

import com.sri.service.CustomConfigurationConnectionProviderImpl;

public class CustomConfigurableConnectionProviderInitiator implements StandardServiceInitiator<ConnectionProvider> {

	@Override
	public Class<ConnectionProvider> getServiceInitiated() {
		return ConnectionProvider.class;
	}

	@Override
	public ConnectionProvider initiateService(Map properties, ServiceRegistryImplementor registry) {
		CustomConfigurationConnectionProviderImpl customConfigurationProvider = null;

		customConfigurationProvider = new CustomConfigurationConnectionProviderImpl();
		return customConfigurationProvider;
	}

}
