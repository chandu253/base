package org.stackspace.webfaces.context.object.factory;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.stackspace.webfaces.context.object.MapContextObject;
import org.stackspace.webfaces.context.object.mapper.HttpMapper;

public class ContextObjectFactory {
	public static MapContextObject getContextObject(HttpServletRequest request) {
		MapContextObject contextObject = null;
		Map<String, String[]> requestMap = null;

		requestMap = HttpMapper.extract(request);
		contextObject = new MapContextObject(requestMap);
		return contextObject;
	}

	public static void bindContextObject(HttpServletRequest request, MapContextObject contextObject) {
		HttpMapper.bind(request, contextObject);
	}
}
