package com.dt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dt.command.JobCommand;
import com.dt.controller.PostJobController;
import com.dt.exception.CreateJobFailedException;

public class DTTest {
	public static void main(String[] args) throws CreateJobFailedException {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/dt/common/application-context.xml");
		PostJobController pjController = context.getBean("postJobController", PostJobController.class);
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

		pjController.execute(jCommand);
		System.out.println("job posted");
	}
}
