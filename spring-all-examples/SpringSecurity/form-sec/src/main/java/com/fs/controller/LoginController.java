package com.fs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/login.htm")
	public String showLogin(HttpServletRequest request, Model model) {
		List<String> popularMovies = null;

		popularMovies = new ArrayList<>();
		popularMovies.add("padmavat");
		popularMovies.add("bagmati");
		popularMovies.add("Tiger Jinda Hai");

		if (request.getParameter("error") != null && request.getParameter("error").equals("failed")) {
			model.addAttribute("error", "Username or Password is not valid");
		}

		model.addAttribute("popularMovies", popularMovies);
		return "login";
	}
}
