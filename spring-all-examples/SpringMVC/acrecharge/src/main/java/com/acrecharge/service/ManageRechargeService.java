package com.acrecharge.service;

import java.util.ArrayList;
import java.util.List;

import com.acrecharge.bo.RechargeOrderBo;
import com.acrecharge.dao.RechargeDao;
import com.acrecharge.dto.OrderDto;

public class ManageRechargeService {
	private RechargeDao rechargeDao;

	public List<OrderDto> getRechargeOrders() {
		List<RechargeOrderBo> orderBos = null;
		List<OrderDto> orderDtos = null;
		OrderDto dto = null;

		orderBos = rechargeDao.getRechargeOrders();
		orderDtos = new ArrayList<>();
		for (RechargeOrderBo bo : orderBos) {
			dto = new OrderDto();
			dto.setOrderNo(bo.getOrderNo());
			dto.setOrderedDate(bo.getOrderedDate());
			dto.setMobileNumber(bo.getMobileNumber());
			dto.setAmount(bo.getAmount());
			dto.setStatus(bo.getStatus());
			orderDtos.add(dto);
		}

		return orderDtos;
	}

	public void setRechargeDao(RechargeDao rechargeDao) {
		this.rechargeDao = rechargeDao;
	}

}
