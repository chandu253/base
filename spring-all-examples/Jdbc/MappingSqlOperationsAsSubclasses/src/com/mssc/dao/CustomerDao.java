package com.mssc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

import com.mssc.bo.CustomerBo;

public class CustomerDao {
	private final String SQL_GET_CUSTOMERS_BY_FIRST_NM = "select customer_no, first_nm, last_nm, mobile, email_address from customer where first_nm like ?";
	private final String SQL_UPD_CUSTOMER_BY_NO = "update customer set first_nm = ?, last_nm = ? where customer_no = ?";

	private DataSource dataSource;
	private GetCustomersByFirstName getCustomersByFirstName;
	private UpdateCustomerFirstAndLastName updateCustomerFirstAndLastName;

	public CustomerDao(DataSource dataSource) {
		this.dataSource = dataSource;
		getCustomersByFirstName = new GetCustomersByFirstName(dataSource);
		updateCustomerFirstAndLastName = new UpdateCustomerFirstAndLastName(dataSource);
	}

	public List<CustomerBo> getCustomers(String firstName) {
		return getCustomersByFirstName.execute(new Object[] { firstName });
	}

	public int updateCustomer(String firstName, String lastName, int customerNo) {
		return updateCustomerFirstAndLastName.update(new Object[] { firstName, lastName, customerNo });
	}

	private final class GetCustomersByFirstName extends MappingSqlQuery<CustomerBo> {
		public GetCustomersByFirstName(DataSource dataSource) {
			super(dataSource, SQL_GET_CUSTOMERS_BY_FIRST_NM);
			declareParameter(new SqlParameter(Types.VARCHAR));
			compile();
		}

		@Override
		protected CustomerBo mapRow(ResultSet rs, int row) throws SQLException {
			CustomerBo bo = new CustomerBo();
			bo.setCustomerNo(rs.getInt(1));
			bo.setFirstName(rs.getString(2));
			bo.setLastName(rs.getString(3));
			bo.setMobile(rs.getString(4));
			bo.setEmailAddress(rs.getString(5));
			return bo;
		}
	}

	private final class UpdateCustomerFirstAndLastName extends SqlUpdate {

		public UpdateCustomerFirstAndLastName(DataSource ds) {
			super(ds, SQL_UPD_CUSTOMER_BY_NO);
			declareParameter(new SqlParameter(Types.VARCHAR));
			declareParameter(new SqlParameter(Types.VARCHAR));
			declareParameter(new SqlParameter(Types.INTEGER));
			compile();
		}
	}

}
