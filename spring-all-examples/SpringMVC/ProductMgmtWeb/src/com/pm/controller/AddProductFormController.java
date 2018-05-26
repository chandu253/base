package com.pm.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.pm.command.ProductCommand;

public class AddProductFormController extends SimpleFormController {

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		ProductCommand pc = null;
		ModelAndView mav = null;

		pc = (ProductCommand) command;
		mav = new ModelAndView();
		mav.addObject("title", pc.getTitle());
		mav.setViewName("success");
		return mav;
	}

}
