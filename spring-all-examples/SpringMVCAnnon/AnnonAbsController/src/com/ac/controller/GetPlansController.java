package com.ac.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ac.dto.Plan;

@Controller
public class GetPlansController {

	@RequestMapping("/plans.htm")
	public void showPlansByProvider(@RequestParam("provider") String provider, ModelMap modelMap) {
		List<Plan> plans = null;

		plans = new ArrayList<>();
		if (provider.equals("airtel")) {
			plans.add(new Plan("airtel-199", 30, 90));
			plans.add(new Plan("airtel-449", 30, 449));
		} else if (provider.equals("vodafone")) {
			plans.add(new Plan("vodafone-100", 27, 100));
			plans.add(new Plan("vodafone-399", 30, 399));
		}

		modelMap.addAttribute("plans", plans);
	}

}
