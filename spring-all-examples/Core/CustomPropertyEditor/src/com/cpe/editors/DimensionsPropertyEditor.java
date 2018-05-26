package com.cpe.editors;

import java.beans.PropertyEditorSupport;

import com.cpe.beans.Dimensions;

public class DimensionsPropertyEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Dimensions dimensions = null;
		String[] tokens = null;

		tokens = text.split(",");
		if (tokens.length != 3) {
			throw new IllegalArgumentException("invalid value provided");
		}
		dimensions = new Dimensions();
		dimensions.setLength(Integer.parseInt(tokens[0]));
		dimensions.setWidth(Integer.parseInt(tokens[1]));
		dimensions.setThickness(Integer.parseInt(tokens[2]));
		setValue(dimensions);
	}
}
