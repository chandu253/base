package com.at.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.at.command.JobCommand;
import com.at.service.JobService;

@Controller
public class PostJobController {
	@Autowired
	private JobService jobService;

	public void postJob(JobCommand jobCommand) {
		jobService.postJob(jobCommand);
	}
}
