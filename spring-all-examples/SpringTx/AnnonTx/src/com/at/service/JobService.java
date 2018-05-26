package com.at.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.at.bo.CompanyBo;
import com.at.bo.JobBo;
import com.at.command.JobCommand;
import com.at.dao.CompanyDao;
import com.at.dao.JobDao;

@Service
public class JobService {
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private JobDao jobDao;

	@Transactional(readOnly = false)
	public void postJob(JobCommand jobCommand) {
		CompanyBo companyBo = null;
		JobBo jobBo = null;

		companyBo = new com.at.bo.CompanyBo();
		companyBo.setCompanyId(jobCommand.getCompanyId());
		companyBo.setCompanyName(jobCommand.getCompanyName());
		companyBo.setServiceType(jobCommand.getServiceType());
		companyBo.setLocation(jobCommand.getLocation());
		companyDao.saveCompany(companyBo);

		jobBo = new JobBo();
		jobBo.setJobNo(jobCommand.getJobNo());
		jobBo.setTitle(jobCommand.getTitle());
		jobBo.setDescription(jobCommand.getDescription());
		jobBo.setExperience(jobCommand.getExperience());
		jobBo.setQualification(jobCommand.getQualification());
		// jobBo.setCompanyId(jobCommand.getCompanyId());
		jobBo.setCompanyId(2);

		jobDao.saveJob(jobBo);

	}
}
