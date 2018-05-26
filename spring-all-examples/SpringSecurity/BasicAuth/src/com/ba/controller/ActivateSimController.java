package com.ba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActivateSimController {
	@RequestMapping("/activate.htm")
	public String activate(@RequestParam("simNo") String simNo, Model model) {
		model.addAttribute("simNo", simNo);
		return "activated";
	}
}
