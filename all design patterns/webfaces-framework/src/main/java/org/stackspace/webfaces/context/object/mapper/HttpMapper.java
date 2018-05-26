package org.stackspace.webfaces.context.object.mapper;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.stackspace.webfaces.context.object.MapContextObject;

public class HttpMapper {
	public static Map<String, String[]> extract(HttpServletRequest request) {
		return request.getParameterMap();
	}

	public static void bind(HttpServletRequest request, MapContextObject contextObject) {
		Map<String, Object> responseDataMap = null;

		responseDataMap = contextObject.getAttributes();
		for (String paramName : responseDataMap.keySet()) {
			request.setAttribute(paramName, responseDataMap.get(paramName));
		}

	}
}
