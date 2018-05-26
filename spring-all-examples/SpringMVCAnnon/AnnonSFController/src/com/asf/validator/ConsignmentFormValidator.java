package com.asf.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.asf.form.ConsignmentForm;
import com.asf.util.ValidationUtils;

@Component
public class ConsignmentFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> classType) {
		if (classType.isAssignableFrom(ConsignmentForm.class)) {
			return true;
		}
		return false;
	}

	@Override
	public void validate(Object object, Errors errors) {
		ConsignmentForm cForm = null;

		cForm = (ConsignmentForm) object;

		if (ValidationUtils.isEmpty(cForm.getSource())) {
			errors.rejectValue("source", "source.blank");
		}
		if (ValidationUtils.isEmpty(cForm.getDestination())) {
			errors.rejectValue("destination", "destination.blank");
		}
		if (ValidationUtils.isEmpty(cForm.getFromAddressLine1())) {
			errors.rejectValue("fromAddressLine1", "fromAddressLine1.blank");
		}
		if (ValidationUtils.isEmpty(cForm.getToAddressLine1())) {
			errors.rejectValue("toAddressLine1", "toAddressLine1.blank");
		}

		if (ValidationUtils.isEmpty(cForm.getFromMobile())) {
			errors.rejectValue("fromMobile", "fromMobile.blank");
		}
		if (ValidationUtils.isEmpty(cForm.getToMobile())) {
			errors.rejectValue("toMobile", "toMobile.blank");
		}

		if (ValidationUtils.isEmpty(cForm.getDescription())) {
			errors.rejectValue("description", "description.blank");
		}
		if (cForm.getWeight() <= 0) {
			errors.rejectValue("weight", "weight.invalid");
		}

		if (cForm.getAmount() <= 0) {
			errors.rejectValue("amount", "amount.invalid");
		}

	}

}
