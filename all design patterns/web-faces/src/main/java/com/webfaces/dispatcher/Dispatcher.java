package com.webfaces.dispatcher;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webfaces.exception.ViewCreationFailedException;

public class Dispatcher {
	public static void dispatch(HttpServletRequest request, HttpServletResponse response, String outcome,
			Properties viewConfigProps) {
		String view = null;

		try {
			if (viewConfigProps.containsKey(outcome) == false) {
				throw new ViewCreationFailedException("unable to find view for outcome : " + outcome);
			}
			view = viewConfigProps.getProperty(outcome);
			request.getRequestDispatcher(view).forward(request, response);
		} catch (Exception e) {
			throw new ViewCreationFailedException("unable to render the view : " + outcome);
		}
	}
}
