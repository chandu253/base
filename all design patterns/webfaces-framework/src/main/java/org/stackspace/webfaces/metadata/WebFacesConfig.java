package org.stackspace.webfaces.metadata;

import java.util.List;
import java.util.Map;

import org.stackspace.webfaces.exception.CommandConfigNotFoundException;
import org.stackspace.webfaces.exception.ForwardConfigNotFoundException;

public class WebFacesConfig {
	protected Map<String, CommandMetadata> commandConfigsMap;
	protected List<ForwardMetadata> globalForwards;

	public WebFacesConfig(Map<String, CommandMetadata> commandConfigsMap, List<ForwardMetadata> globalForwards) {
		this.commandConfigsMap = commandConfigsMap;
		this.globalForwards = globalForwards;
	}

	public String getCommandClass(String path) {
		String commandClass = null;
		CommandMetadata commandMetadata = null;

		if (commandConfigsMap.containsKey(path) == false) {
			throw new CommandConfigNotFoundException("no matching command found for the path : " + path);
		}
		commandMetadata = commandConfigsMap.get(path);
		commandClass = commandMetadata.getCommandClass();

		return commandClass;
	}

	public String getForwardPage(String outcome, String path) {
		String page = null;
		CommandMetadata commandMetadata = null;
		List<ForwardMetadata> commandForwards = null;

		// look into command metadata forwards
		commandMetadata = commandConfigsMap.get(path);
		commandForwards = commandMetadata.getForwards();
		for (ForwardMetadata cForward : commandForwards) {
			if (cForward.getOutcome().equals(outcome)) {
				page = cForward.getPage();
				break;
			}
		}

		// if command forward outcome is not available
		if (page == null) {
			for (ForwardMetadata gForward : globalForwards) {
				if (gForward.getOutcome().equals(outcome)) {
					page = gForward.getPage();
					break;
				}
			}
		}

		if (page == null) {
			throw new ForwardConfigNotFoundException("no forwards available for outcome : " + outcome);
		}

		return page;
	}

}
