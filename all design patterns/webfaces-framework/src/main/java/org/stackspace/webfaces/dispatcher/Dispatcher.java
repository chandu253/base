package org.stackspace.webfaces.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.stackspace.webfaces.exception.WebFacesException;
import org.stackspace.webfaces.metadata.WebFacesConfig;

public class Dispatcher {
	public static void dispatch(HttpServletRequest request, HttpServletResponse response, String outcome, String path,
			WebFacesConfig webFacesConfig) {
		String page = null;

		try {
			page = webFacesConfig.getForwardPage(outcome, path);
			request.getRequestDispatcher(page).forward(request, response);
		} catch (ServletException | IOException e) {
			throw new WebFacesException("unable to dispatch to page : " + page, e);
		}
	}
}
