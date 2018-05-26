package org.stackspace.webfaces.command;

import org.stackspace.webfaces.context.object.MapContextObject;

public interface Command {
	String execute(MapContextObject contextObject);
}
