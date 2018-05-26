package com.at.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.at.bo.CompanyBo;

@Repository
public class CompanyDao {
	private final String SQL_INSERT_COMPANY = "insert into company(company_id, company_nm, service_type, location) values(?,?,?,?)";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveCompany(CompanyBo companyBo) {
		jdbcTemplate.update(SQL_INSERT_COMPANY, new Object[] { companyBo.getCompanyId(), companyBo.getCompanyName(),
				companyBo.getServiceType(), companyBo.getLocation() });
	}
}
