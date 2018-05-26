package com.dt.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.dt.bo.CompanyBo;

public class CompanyDao {
	private final String SQL_INSERT_COMPANY = "insert into company(company_id, company_nm, service_type, location) values(:companyId, :companyName, :serviceType, :location)";
	private NamedParameterJdbcTemplate npJdbcTemplate;

	public CompanyDao(NamedParameterJdbcTemplate npJdbcTemplate) {
		this.npJdbcTemplate = npJdbcTemplate;
	}

	public void saveCompany(CompanyBo companyBo) {
		BeanPropertySqlParameterSource paramSource = null;

		paramSource = new BeanPropertySqlParameterSource(companyBo);
		npJdbcTemplate.update(SQL_INSERT_COMPANY, paramSource);
	}

}
