package com.lm.annon;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class Container {
	public void recieve(String data) {
		RequestHandler handler = null;

		handler = lookupRequestHandler();
		handler.setData(data);
		handler.handle();
	}

	@Lookup("requestHandler")
	public RequestHandler lookupRequestHandler() {
		return null;
	}
}
