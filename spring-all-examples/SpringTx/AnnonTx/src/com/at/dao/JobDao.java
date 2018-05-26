package com.at.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.at.bo.JobBo;

@Repository
public class JobDao {
	private final String SQL_INSERT_JOB = "insert into job(job_no, title, description, experience, qualification, company_id) values(?,?,?,?,?,?)";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveJob(JobBo jobBo) {
		jdbcTemplate.update(SQL_INSERT_JOB, new Object[] { jobBo.getJobNo(), jobBo.getTitle(), jobBo.getDescription(),
				jobBo.getExperience(), jobBo.getQualification(), jobBo.getCompanyId() });
	}
}
