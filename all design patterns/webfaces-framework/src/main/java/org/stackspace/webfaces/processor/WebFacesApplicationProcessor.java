package org.stackspace.webfaces.processor;

import javax.servlet.http.HttpServletResponse;

import org.stackspace.webfaces.command.Command;
import org.stackspace.webfaces.command.helper.CommandHelper;
import org.stackspace.webfaces.context.object.MapContextObject;
import org.stackspace.webfaces.context.object.factory.ContextObjectFactory;
import org.stackspace.webfaces.dispatcher.Dispatcher;
import org.stackspace.webfaces.metadata.WebFacesConfig;

import javax.servlet.http.HttpServletRequest;

public class WebFacesApplicationProcessor {
	public void process(HttpServletRequest request, HttpServletResponse response, WebFacesConfig webFacesConfig) {
		String path = null;
		String outcome = null;
		Command command = null;
		MapContextObject contextObject = null;

		path = request.getServletPath();
		command = CommandHelper.getCommand(path, webFacesConfig);
		contextObject = ContextObjectFactory.getContextObject(request);
		outcome = command.execute(contextObject);
		ContextObjectFactory.bindContextObject(request, contextObject);
		Dispatcher.dispatch(request, response, outcome, path, webFacesConfig);
	}
}
