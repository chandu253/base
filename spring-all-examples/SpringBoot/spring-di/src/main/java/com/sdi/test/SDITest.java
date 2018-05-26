package com.sdi.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.sdi.beans.Robot;
import com.sdi.runner.SDICommandLineRunner;

@SpringBootApplication(scanBasePackages = { "com.sdi.beans" })
@ImportResource("classpath:com/sdi/common/application-context.xml")
public class SDITest {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SDITest.class, args);
		Robot robot = context.getBean("robot", Robot.class);
		robot.walk();
	}

	@Bean
	public SDICommandLineRunner commandLineRunner() {
		return new SDICommandLineRunner();
	}
}
