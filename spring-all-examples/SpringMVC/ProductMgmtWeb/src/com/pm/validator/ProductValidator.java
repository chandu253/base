package com.pm.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pm.command.ProductCommand;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> classType) {
		return classType.isAssignableFrom(ProductCommand.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
		ProductCommand pc = null;
		
		pc = (ProductCommand) command;
		
		if(pc.getTitle() == null || pc.getTitle().trim().length() == 0) {
			errors.rejectValue("title", "title.blank");
		}
		
		if(pc.getCategory() == null || pc.getCategory().trim().length() == 0) {
			errors.rejectValue("category", "category.blank");
		}
	}

}












