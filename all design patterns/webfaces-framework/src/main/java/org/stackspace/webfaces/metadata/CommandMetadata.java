package org.stackspace.webfaces.metadata;

import java.util.List;

public class CommandMetadata {
	protected String path;
	protected String commandClass;
	protected List<ForwardMetadata> forwards;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCommandClass() {
		return commandClass;
	}

	public void setCommandClass(String commandClass) {
		this.commandClass = commandClass;
	}

	public List<ForwardMetadata> getForwards() {
		return forwards;
	}

	public void setForwards(List<ForwardMetadata> forwards) {
		this.forwards = forwards;
	}

}
