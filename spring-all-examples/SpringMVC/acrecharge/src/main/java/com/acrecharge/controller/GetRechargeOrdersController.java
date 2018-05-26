package com.acrecharge.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.acrecharge.dto.OrderDto;
import com.acrecharge.service.ManageRechargeService;

public class GetRechargeOrdersController extends AbstractController {
	private ManageRechargeService manageRechargeService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<OrderDto> orderDtos = null;
		ModelAndView mav = null;

		orderDtos = manageRechargeService.getRechargeOrders();
		mav = new ModelAndView();
		mav.addObject("rechargeOrders", orderDtos);
		mav.setViewName("recharge-history");

		return mav;
	}

	public void setManageRechargeService(ManageRechargeService manageRechargeService) {
		this.manageRechargeService = manageRechargeService;
	}

}
