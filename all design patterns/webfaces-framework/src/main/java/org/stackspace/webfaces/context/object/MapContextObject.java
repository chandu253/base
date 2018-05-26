package org.stackspace.webfaces.context.object;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MapContextObject implements Serializable {
	private Map<String, String[]> requestMap;
	private Map<String, Object> responseMap;

	public MapContextObject(Map<String, String[]> requestMap) {
		this.requestMap = requestMap;
		responseMap = new HashMap<>();
	}

	public String getParameter(String paramName) {
		String paramValue = null;

		if (requestMap.containsKey(paramName)) {
			String[] paramValues = requestMap.get(paramName);
			if (paramValues != null && paramValues.length > 0) {
				paramValue = paramValues[0];
			}
		}
		return paramValue;
	}

	public String[] getParameterValues(String paramName) {
		String[] paramValues = null;

		if (requestMap.containsKey(paramName)) {
			paramValues = requestMap.get(paramName);
		}
		return paramValues;
	}

	public Map<String, String[]> getParameters() {
		return requestMap;
	}

	public void addAttribute(String paramName, Object paramValue) {
		responseMap.put(paramName, paramValue);
	}

	public Object getAttribute(String paramName) {
		return responseMap.get(paramName);
	}

	public Map<String, Object> getAttributes() {
		return responseMap;
	}

}
