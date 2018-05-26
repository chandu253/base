package com.acc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acc.dto.PlanDto;
import com.acc.form.SearchForm;

@Controller
public class PlanSearchController {
	@RequestMapping("/dosearchplans.htm")
	public String doSearchPlans(Model model, @ModelAttribute SearchForm searchForm, BindingResult errors) {
		List<PlanDto> plans = null;

		plans = new ArrayList<>();
		plans.add(new PlanDto(1, searchForm.getPlanName(), 30, "Airtel", 499));
		plans.add(new PlanDto(2, "499-Plan", searchForm.getValidity(), "Vodafone", 499));
		plans.add(new PlanDto(1, "399-Plan", 28, "Idea", searchForm.getAmount()));

		model.addAttribute("plans", plans);
		return "matching-plans";
	}
}
