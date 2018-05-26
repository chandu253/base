package com.webfaces.command.helper;

import java.util.Properties;

import com.webfaces.command.Command;
import com.webfaces.exception.CommandCreationFailedException;

public class CommandHelper {
	public static Command getCommand(String requestUri, Properties commandConfigProps) {
		String commandClass = null;
		Command command = null;

		try {
			commandClass = commandConfigProps.getProperty(requestUri);
			command = (Command) Class.forName(commandClass).newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new CommandCreationFailedException("unable to create command for the request uri : " + requestUri, e);
		}
		return command;
	}
}
