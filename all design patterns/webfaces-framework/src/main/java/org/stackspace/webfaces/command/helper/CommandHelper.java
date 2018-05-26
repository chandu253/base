package org.stackspace.webfaces.command.helper;

import org.stackspace.webfaces.command.Command;
import org.stackspace.webfaces.exception.CommandCreationFailedException;
import org.stackspace.webfaces.metadata.WebFacesConfig;

public class CommandHelper {
	public static Command getCommand(String path, WebFacesConfig webFacesConfig) {
		Command command = null;
		String commandClass = null;

		try {
			commandClass = webFacesConfig.getCommandClass(path);
			command = (Command) Class.forName(commandClass).newInstance();
		} catch (Exception e) {
			throw new CommandCreationFailedException("error while creating command class object : " + commandClass, e);
		}

		return command;
	}
}
