package com.acc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.acc.command.ProductSearchCommand;
import com.acc.dto.Product;

public class ProductSearchCommandController extends AbstractCommandController {
	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException bindException) throws Exception {
		ProductSearchCommand pscCommand = null;
		List<Product> products = null;
		Product product = null;
		ModelAndView mav = null;

		pscCommand = (ProductSearchCommand) command;
		products = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			product = new Product();
			product.setProductNo(i + 1);
			product.setTitle("Product" + i);
			product.setDescription("no description");
			products.add(product);
		}
		mav = new ModelAndView();
		mav.addObject("products", products);
		mav.setViewName("product-results");

		return mav;
	}

}
