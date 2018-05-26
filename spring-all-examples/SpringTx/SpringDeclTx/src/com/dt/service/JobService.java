package com.dt.service;

import org.springframework.dao.DataAccessException;

import com.dt.bo.CompanyBo;
import com.dt.bo.JobBo;
import com.dt.command.JobCommand;
import com.dt.dao.CompanyDao;
import com.dt.dao.JobDao;
import com.dt.exception.CreateJobFailedException;

public class JobService {
	private CompanyDao companyDao;
	private JobDao jobDao;

	public void postJob(JobCommand jobCommand) throws CreateJobFailedException {
		CompanyBo companyBo = null;
		JobBo jobBo = null;

		try {
			companyBo = new CompanyBo();
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
		} catch (DataAccessException e) {
			throw new CreateJobFailedException("job creating failed", e);
		}
	}

	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;

	}

	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}

}
