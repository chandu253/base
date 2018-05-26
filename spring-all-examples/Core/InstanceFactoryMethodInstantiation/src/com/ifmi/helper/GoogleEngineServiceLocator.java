package com.ifmi.helper;

import com.ifmi.ext.beans.IGoogleEngine;
import com.ifmi.ext.beans.IndiaGoogleEngine;
import com.ifmi.ext.beans.USGoogleEngine;

public class GoogleEngineServiceLocator {
	public IGoogleEngine locateIndiaGoogleEngine() {
		// lookup logic to acquire references of remote application
		return new IndiaGoogleEngine();
	}

	public IGoogleEngine locateUSGoogleEngine() {
		return new USGoogleEngine();
	}
}
