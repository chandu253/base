package com.qa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.qa.bo.CustomerBo;
import com.qa.bo.CustomerJobsheetBo;
import com.qa.bo.JobsheetBo;

public class CustomerDao {
	private final String SQL_GET_NO_OF_CUSTOMERS = "select count(1) from customer";
	private final String SQL_FIND_FIRST_NM_OF_CUSTOMER_BY_MOBILE = "select first_nm from customer where mobile = ?";
	private final String SQL_FIND_CUSTOMER_BY_NO = "select customer_no, first_nm, last_nm, mobile, email_address from customer where customer_no = ?";
	private final String SQL_GET_CUSTOMERS = "select customer_no, first_nm, last_nm, mobile, email_address from customer";
	private final String SQL_GET_CUSTOMERS_WITH_JOBSHEETS = "select c.customer_no, c.first_nm, c.last_nm, c.mobile, c.email_address, js.job_sheet_no, js.opened_dt, js.job_sheet_type, js.kilometers, js.petrol_level, js.engine_no from customer c inner join job_sheets js on c.customer_no = js.customer_no";
	private final String SQL_GET_JOBSHEETS = "select job_sheet_no, opened_dt, job_sheet_type, kilometers, petrol_level, engine_no from job_sheets order by opened_dt desc";
	private final String SQL_SAVE_CUSTOMER = "insert into customer(customer_no, first_nm, last_nm, mobile, email_address) values (?,?,?,?,?)";
	private final String SQL_AUTO_GEN_SAVE_CUSTOMER = "insert into customer(first_nm, last_nm, mobile, email_address) values(?,?,?,?)";

	private JdbcTemplate jdbcTemplate;

	public CustomerDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int getNoOfCustomers() {
		return jdbcTemplate.queryForInt(SQL_GET_NO_OF_CUSTOMERS);
	}

	public String findCustomerFirstName(String mobile) {
		return jdbcTemplate.queryForObject(SQL_FIND_FIRST_NM_OF_CUSTOMER_BY_MOBILE, String.class,
				new Object[] { mobile });
	}

	public CustomerBo findCustomer(int customerNo) {
		return jdbcTemplate.queryForObject(SQL_FIND_CUSTOMER_BY_NO, new CustomerRowMapper(),
				new Object[] { customerNo });
	}

	public List<CustomerBo> getCustomers() {
		return jdbcTemplate.query(SQL_GET_CUSTOMERS, new CustomerRowMapper());
	}

	public List<CustomerJobsheetBo> getCustomersWithJobsheets() {
		return jdbcTemplate.query(SQL_GET_CUSTOMERS_WITH_JOBSHEETS, new CustomerJobsheetExtractor());
	}

	public List<JobsheetBo> getJobsheets(int pageNo, int pageSize) {
		return (List<JobsheetBo>) jdbcTemplate.query(SQL_GET_JOBSHEETS,
				new JobsheetPaginationResultSetExtractor(pageNo, pageSize));
	}

	public int saveCustomer(CustomerBo cBo) {
		return jdbcTemplate.update(SQL_SAVE_CUSTOMER, new Object[] { cBo.getCustomerNo(), cBo.getFirstName(),
				cBo.getLastName(), cBo.getMobile(), cBo.getEmailAddress() });
	}

	public long saveAutoGenCustomer(CustomerBo cBo) {
		GeneratedKeyHolder kh = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = null;
				pstmt = con.prepareStatement(SQL_AUTO_GEN_SAVE_CUSTOMER, new String[] { "customer_no" });
				pstmt.setString(1, cBo.getFirstName());
				pstmt.setString(2, cBo.getLastName());
				pstmt.setString(3, cBo.getMobile());
				pstmt.setString(4, cBo.getEmailAddress());
				return pstmt;
			}
		}, kh);
		//Map<String, Object> keys = kh.getKeys();
		long cNo = (long) kh.getKey();

		return cNo;
	}

	private final class JobsheetPaginationResultSetExtractor extends AbstractPaginationResultsetExtractor {

		public JobsheetPaginationResultSetExtractor(int pageNo, int pageSize) {
			super(pageNo, pageSize);
		}

		@Override
		protected Object mapRow(ResultSet rs) throws SQLException {
			JobsheetBo jBo = null;

			jBo = new JobsheetBo();
			jBo.setJobsheetNo(rs.getInt(1));
			jBo.setOpenedDate(rs.getDate(2));
			jBo.setJobSheetType(rs.getString(3));
			jBo.setKilometers(rs.getInt(4));
			jBo.setPetrolLevel(rs.getInt(5));
			jBo.setEngineNo(rs.getString(6));
			return jBo;
		}
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

	private final class CustomerJobsheetExtractor implements ResultSetExtractor<List<CustomerJobsheetBo>> {
		@Override
		public List<CustomerJobsheetBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Integer, CustomerJobsheetBo> customerJobSheetMap = null;
			CustomerBo cBo = null;
			JobsheetBo jBo = null;
			int customerNo = 0;
			CustomerJobsheetBo bo = null;
			List<JobsheetBo> jobsheets = null;
			List<CustomerJobsheetBo> customerJobsheets;

			customerJobSheetMap = new HashMap<>();
			while (rs.next()) {
				customerNo = rs.getInt(1);
				if (customerJobSheetMap.containsKey(customerNo) == false) {
					cBo = new CustomerBo();
					cBo.setCustomerNo(rs.getInt(1));
					cBo.setFirstName(rs.getString(2));
					cBo.setLastName(rs.getString(3));
					cBo.setMobile(rs.getString(4));
					cBo.setEmailAddress(rs.getString(5));

					bo = new CustomerJobsheetBo();
					bo.setCustomer(cBo);
					jobsheets = new ArrayList<>();
					bo.setJobsheets(jobsheets);
					customerJobSheetMap.put(customerNo, bo);
				} else {
					bo = customerJobSheetMap.get(customerNo);
					jobsheets = bo.getJobsheets();
				}
				jBo = new JobsheetBo();
				jBo.setJobsheetNo(rs.getInt(6));
				jBo.setOpenedDate(rs.getDate(7));
				jBo.setJobSheetType(rs.getString(8));
				jBo.setKilometers(rs.getInt(9));
				jBo.setPetrolLevel(rs.getInt(10));
				jBo.setEngineNo(rs.getString(11));
				jobsheets.add(jBo);
			}
			customerJobsheets = new ArrayList<>();
			for (Integer key : customerJobSheetMap.keySet()) {
				customerJobsheets.add(customerJobSheetMap.get(key));
			}

			return customerJobsheets;
		}
	}
}
