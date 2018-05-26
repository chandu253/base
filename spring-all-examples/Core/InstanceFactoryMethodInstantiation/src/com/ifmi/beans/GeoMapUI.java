package com.ifmi.beans;

import com.ifmi.ext.beans.IGoogleEngine;
import com.ifmi.helper.GoogleEngineServiceLocator;

public class GeoMapUI {
	private IGoogleEngine googleEngine;

	public void render(String source, String destination) {
		String[] cooridnates = null;

		cooridnates = googleEngine.getDirections(source, destination);
		for (String co : cooridnates) {
			System.out.println(co);
		}

	}

	public void setGoogleEngine(IGoogleEngine googleEngine) {
		this.googleEngine = googleEngine;
	}

}
