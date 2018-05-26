package com.npjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.npjdbc.bo.CustomerBo;

public class CustomerDao {
	private final String SQL_GET_NO_OF_CUSTOMERS_BY_NM = "select count(1) from customer where first_nm like :fName and last_nm like :lName";
	private final String SQL_GET_CUSTOMERS_BY_EMAIL = "select customer_no, first_nm, last_nm, mobile, email_address from customer where email_address like :email";
	private final String SQL_SAVE_CUSTOMER = "insert into customer(customer_no, first_nm, last_nm, mobile, email_address) values(:customerNo, :firstName, :lastName, :mobile, :emailAddress)";

	private NamedParameterJdbcTemplate npJdbcTemplate;
	private SimpleJdbcInsert customerJdbcInsert;
	private SimpleJdbcCall sJdbcCall;

	public CustomerDao(DataSource dataSource) {
		this.npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		customerJdbcInsert = new SimpleJdbcInsert(dataSource);
		customerJdbcInsert.setTableName("customer");
		sJdbcCall = new SimpleJdbcCall(dataSource);
	}

	public int getNoOfCustomers(String firstName, String lastName) {
		Map<String, Object> paramMap = null;

		paramMap = new HashMap<String, Object>();
		paramMap.put("fName", firstName);
		paramMap.put("lName", lastName);

		return npJdbcTemplate.queryForInt(SQL_GET_NO_OF_CUSTOMERS_BY_NM, paramMap);
	}

	public List<CustomerBo> getCustomers(String emailAddress) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("email", emailAddress);
		return npJdbcTemplate.query(SQL_GET_CUSTOMERS_BY_EMAIL, paramSource, new CustomerRowMapper());
	}
	
	public void saveCustomer(CustomerBo bo) {
		// npJdbcTemplate.update(SQL_SAVE_CUSTOMER, new BeanPropertySqlParameterSource(bo));
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("customer_no", bo.getCustomerNo());
		paramSource.addValue("first_nm", bo.getFirstName());
		paramSource.addValue("last_nm", bo.getLastName());
		paramSource.addValue("mobile", bo.getMobile());
		paramSource.addValue("email_address", bo.getEmailAddress());
		customerJdbcInsert.execute(paramSource);
	}
	
	public void add(int a, int b) {
		Map<String, Object> outMap = null;
		
		sJdbcCall.setProcedureName("add_values");
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("A", a);
		paramSource.addValue("B", b);
		outMap = sJdbcCall.execute(paramSource);
		System.out.println(outMap.get("SUM"));
	}

	private final class CustomerRowMapper implements RowMapper<CustomerBo> {
		@Override
		public CustomerBo mapRow(ResultSet rs, int row) throws SQLException {
			CustomerBo bo = new CustomerBo();
			bo.setCustomerNo(rs.getInt(1));
			bo.setFirstName(rs.getString(2));
			bo.setLastName(rs.getString(3));
			bo.setMobile(rs.getString(4));
			bo.setEmailAddress(rs.getString(5));

			return bo;
		}
	}
}
