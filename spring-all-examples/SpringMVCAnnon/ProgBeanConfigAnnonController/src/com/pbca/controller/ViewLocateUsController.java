package com.pbca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewLocateUsController {
	@RequestMapping("/locate-us.htm")
	public String showLocateUs() {
		return "locate-us";
	}

}
