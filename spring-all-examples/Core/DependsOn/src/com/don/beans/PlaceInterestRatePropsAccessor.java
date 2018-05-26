package com.don.beans;

import java.io.IOException;
import java.util.Properties;

public class PlaceInterestRatePropsAccessor implements IAccessor {
	protected String key;

	public PlaceInterestRatePropsAccessor(String key) {
		this.key = key;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public Object getData() throws IOException {
		Properties props = null;

		props = new Properties();
		props.load(this.getClass().getClassLoader().getResourceAsStream("interest-rate.properties"));

		return props;
	}

}
