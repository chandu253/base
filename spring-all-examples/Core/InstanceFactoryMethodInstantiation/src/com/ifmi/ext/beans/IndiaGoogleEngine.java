package com.ifmi.ext.beans;

public class IndiaGoogleEngine implements IGoogleEngine {

	@Override
	public String[] getDirections(String source, String destination) {
		return new String[] { "(10,20)", "(10,21)", "(11,24)" };
	}

}
