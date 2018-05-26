package com.cpe.util;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import com.cpe.beans.Dimensions;
import com.cpe.editors.DimensionsPropertyEditor;

/**
 * Used for registering all the property editors of your application
 * 
 * @author sriman
 *
 */
public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Dimensions.class, new DimensionsPropertyEditor());
	}

}



