package com.webfaces.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webfaces.command.Command;
import com.webfaces.command.helper.CommandHelper;
import com.webfaces.dispatcher.Dispatcher;
import com.webfaces.exception.WebFacesConfigException;

public class WebFacesServlet extends HttpServlet {
	private final String COMMAND_CONFIG_FILE = "command-config.properties";
	private final String VIEW_CONFIG_FILE = "view-config.properties";
	protected Properties commandConfigProps;
	protected Properties viewConfigProps;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = null;
		String realPath = null;

		commandConfigProps = new Properties();
		viewConfigProps = new Properties();
		context = config.getServletContext();
		realPath = context.getRealPath("/WEB-INF") + "/";
		System.out.println(realPath);

		try {
			commandConfigProps.load(new FileInputStream(realPath + COMMAND_CONFIG_FILE));
		} catch (Exception e) {
			throw new WebFacesConfigException("unable to read " + COMMAND_CONFIG_FILE, e);
		}

		try {
			viewConfigProps.load(new FileInputStream(realPath + VIEW_CONFIG_FILE));
		} catch (Exception e) {
			throw new WebFacesConfigException("unable to read " + VIEW_CONFIG_FILE, e);
		}
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestUri = null;
		String outcome = null;
		Command command = null;

		requestUri = request.getServletPath();
		command = CommandHelper.getCommand(requestUri, commandConfigProps);
		outcome = command.execute(request, response);
		Dispatcher.dispatch(request, response, outcome, viewConfigProps);
	}

}
