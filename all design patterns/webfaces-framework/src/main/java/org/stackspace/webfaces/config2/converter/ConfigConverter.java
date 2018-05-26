package org.stackspace.webfaces.config2.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.stackspace.webfaces.config2.CommandConfig;
import org.stackspace.webfaces.config2.Forward;
import org.stackspace.webfaces.config2.WebFaces;
import org.stackspace.webfaces.metadata.CommandMetadata;
import org.stackspace.webfaces.metadata.ForwardMetadata;
import org.stackspace.webfaces.metadata.WebFacesConfig;

public class ConfigConverter {
	public WebFacesConfig convert(WebFaces webFaces) {
		Map<String, CommandMetadata> commandConfigsMap = null;
		List<ForwardMetadata> globalForwards = null;
		List<ForwardMetadata> cForwards = null;
		CommandMetadata commandMetadata = null;
		ForwardMetadata forwardMetadata = null;
		WebFacesConfig webFacesConfig = null;

		// converted commandConfigs to Map<String, CommandMetadata>
		commandConfigsMap = new HashMap<>();
		for (CommandConfig commandConfig : webFaces.getCommandConfigs().getCommandConfig()) {
			commandMetadata = new CommandMetadata();
			commandMetadata.setPath(commandConfig.getPath());
			commandMetadata.setCommandClass(commandConfig.getCommandClass());
			cForwards = new ArrayList<>();
			for (Forward cForward : commandConfig.getForward()) {
				forwardMetadata = new ForwardMetadata();
				forwardMetadata.setOutcome(cForward.getOutcome());
				forwardMetadata.setPage(cForward.getPage());
				cForwards.add(forwardMetadata);
			}
			commandMetadata.setForwards(cForwards);
			commandConfigsMap.put(commandConfig.getPath(), commandMetadata);
		}

		globalForwards = new ArrayList<>();
		// global forwards
		for (Forward forward : webFaces.getGlobalForwards().getForward()) {
			forwardMetadata = new ForwardMetadata();
			forwardMetadata.setOutcome(forward.getOutcome());
			forwardMetadata.setPage(forward.getPage());
			globalForwards.add(forwardMetadata);
		}

		webFacesConfig = new WebFacesConfig(commandConfigsMap, globalForwards);
		return webFacesConfig;
	}
}
