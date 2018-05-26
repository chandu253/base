package com.asf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.asf.bo.ConsignmentBo;
import com.asf.bo.ContactBo;

@Repository
public class ConsignmentDao {
	private final String SQL_INS_CONTACT = "insert into contact(contact_nm, address_line1, address_line2, city, state, zip, country, mobile_nbr) values(?,?,?,?,?,?,?,?)";
	private final String SQL_INS_CONSIGNMENT = "insert into consignment(consignment_date, description, shipment_type, weight, amount, from_contact_id, to_contact_id) values(?,?,?,?,?,?,?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int createConsignment(final ConsignmentBo consignmentBo) {
		Integer consignmentNo = null;
		KeyHolder kh = null;

		final Integer fromContactNo = saveContact(consignmentBo.getFromContact());
		final Integer toContactNo = saveContact(consignmentBo.getToContact());

		kh = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = null;

				pstmt = con.prepareStatement(SQL_INS_CONSIGNMENT, new String[] { "CONSIGNMENT_NO" });
				pstmt.setDate(1, new java.sql.Date(consignmentBo.getConsignmentDate().getTime()));
				pstmt.setString(2, consignmentBo.getDescription());
				pstmt.setString(3, consignmentBo.getShipmentType());
				pstmt.setFloat(4, consignmentBo.getWeight());
				pstmt.setFloat(5, consignmentBo.getAmount());
				pstmt.setInt(6, fromContactNo);
				pstmt.setInt(7, toContactNo);

				return pstmt;
			}
		}, kh);
		consignmentNo = kh.getKey().intValue();
		return consignmentNo;
	}

	private Integer saveContact(ContactBo contact) {
		KeyHolder kh = null;
		Integer contactNo = null;

		kh = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = null;

				pstmt = con.prepareStatement(SQL_INS_CONTACT, new String[] { "contact_id" });
				pstmt.setString(1, contact.getContactName());
				pstmt.setString(2, contact.getAddressLine1());
				pstmt.setString(3, contact.getAddressLine2());
				pstmt.setString(4, contact.getCity());
				pstmt.setString(5, contact.getState());
				pstmt.setInt(6, contact.getZip());
				pstmt.setString(7, contact.getCountry());
				pstmt.setString(8, contact.getMobile());

				return pstmt;
			}
		}, kh);

		contactNo = kh.getKey().intValue();
		return contactNo;
	}
}
