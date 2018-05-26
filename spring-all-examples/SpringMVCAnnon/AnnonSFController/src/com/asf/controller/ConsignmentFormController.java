package com.asf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asf.dto.Consignment;
import com.asf.form.ConsignmentForm;
import com.asf.service.ConsignmentService;
import com.asf.validator.ConsignmentFormValidator;

@Controller
@RequestMapping("/newConsignment.htm")
public class ConsignmentFormController {
	@Autowired
	private ConsignmentFormValidator cFormValidator;

	@Autowired
	private ConsignmentService consignmentService;

	@GetMapping
	public String showConsignmentForm(Model model) {
		model.addAttribute("consignmentForm", new ConsignmentForm());
		return "new-consignment";
	}

	@PostMapping
	public String newConsignment(Model model, @ModelAttribute("consignmentForm") ConsignmentForm cForm,
			BindingResult errors) {
		Consignment consignment = null;

		if (cFormValidator.supports(cForm.getClass())) {
			cFormValidator.validate(cForm, errors);
			if (errors.hasErrors()) {
				return "new-consignment";
			}
		}
		consignment = consignmentService.createConsignment(cForm);
		model.addAttribute("consignment", consignment);
		return "consignment-details";
	}
}
