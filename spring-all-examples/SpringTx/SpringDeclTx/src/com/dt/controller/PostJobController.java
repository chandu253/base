package com.dt.controller;

import com.dt.command.JobCommand;
import com.dt.exception.CreateJobFailedException;
import com.dt.service.JobService;

public class PostJobController {
	private JobService jobService;

	public void execute(JobCommand jobCommand) throws CreateJobFailedException {
		jobService.postJob(jobCommand);
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

}
