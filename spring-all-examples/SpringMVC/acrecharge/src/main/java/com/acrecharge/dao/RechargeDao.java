package com.acrecharge.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.acrecharge.bo.RechargeOrderBo;

public class RechargeDao {
	private final String SQL_GET_RECHARGE_ORDERS = "select recharge_order_no, ordered_dt, mobile_nbr, provider_nm, amount, status from recharge_orders order by ordered_dt";
	private JdbcTemplate jdbcTemplate;

	public RechargeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<RechargeOrderBo> getRechargeOrders() {
		return jdbcTemplate.query(SQL_GET_RECHARGE_ORDERS, new RowMapper<RechargeOrderBo>() {
			@Override
			public RechargeOrderBo mapRow(ResultSet rs, int row) throws SQLException {
				RechargeOrderBo ro = null;

				ro = new RechargeOrderBo();
				ro.setOrderNo(rs.getInt(1));
				ro.setOrderedDate(rs.getDate(2));
				ro.setMobileNumber(rs.getString(3));
				ro.setProvider(rs.getString(4));
				ro.setAmount(rs.getFloat(5));
				ro.setStatus(rs.getString(6));
				return ro;
			}
		});
	}

}
