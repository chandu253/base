package com.at.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.at.command.JobCommand;
import com.at.controller.PostJobController;
import com.at.javaconfig.RootConfig;

public class ATTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
		PostJobController pjC = context.getBean("postJobController", PostJobController.class);
		JobCommand jCommand = new JobCommand();
		jCommand.setCompanyId(1);
		jCommand.setCompanyName("Tata Consultancy");
		jCommand.setServiceType("IT");
		jCommand.setLocation("Hyderabad");
		jCommand.setJobNo(1);
		jCommand.setTitle("Senior Software Engineer");
		jCommand.setDescription("3 Years Java/Framework Experience");
		jCommand.setExperience(3);
		jCommand.setQualification("mca");

		pjC.postJob(jCommand);
		System.out.println("job posted");
	}
}
