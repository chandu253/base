package com.dt.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.dt.bo.JobBo;

public class JobDao {
	private final String SQL_INSERT_JOB = "insert into job(job_no, title, description, experience, qualification, company_id) values(:jobNo, :title, :description, :experience, :qualification, :companyId)";
	private NamedParameterJdbcTemplate npJdbcTemplate;

	public JobDao(NamedParameterJdbcTemplate npJdbcTemplate) {
		this.npJdbcTemplate = npJdbcTemplate;
	}

	public void saveJob(JobBo jobBo) {
		BeanPropertySqlParameterSource paramSource = null;

		paramSource = new BeanPropertySqlParameterSource(jobBo);
		npJdbcTemplate.update(SQL_INSERT_JOB, paramSource);
	}

}
