package com.vw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.vw.dto.Product;

public class RecentProductsController extends AbstractController {
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = null;
		String viewType = null;
		List<Product> products = null;

		viewType = request.getParameter("view");
		products = new ArrayList<>();
		products.add(new Product(1, "Television"));
		products.add(new Product(2, "Bike"));
		products.add(new Product(3, "Microwave Oven"));

		mav = new ModelAndView();
		mav.addObject("products", products);

		if (viewType.equals("pdf")) {
			mav.setViewName("rppdf");
		} else {
			mav.setViewName("rpxls");
		}

		return mav;
	}

}
