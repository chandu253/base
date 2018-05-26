package com.sjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sjdbc.bo.ContactBO;

@Repository
public class ContactDao {
	private final String SQL_GET_CONTACT = "select contact_id, contact_nm from contact";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<ContactBO> getContacts() {
		return jdbcTemplate.query(SQL_GET_CONTACT, new RowMapper<ContactBO>() {
			@Override
			public ContactBO mapRow(ResultSet rs, int row) throws SQLException {
				return new ContactBO(rs.getInt("contact_id"), rs.getString("contact_nm"));
			}

		});
	}

}
