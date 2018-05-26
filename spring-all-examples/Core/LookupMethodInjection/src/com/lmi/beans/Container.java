package com.lmi.beans;

abstract public class Container {
	public void recieve(String data) {
		RequestHandler handler = null;

		// dependency lookup (type:dependency pull)
		handler = lookupRequestHandler();
		handler.setData(data);
		handler.handle();
	}

	abstract protected RequestHandler lookupRequestHandler();
}
