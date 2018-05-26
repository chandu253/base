package com.sweb.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.sweb.config.MvcConfig;

@SpringBootApplication
@Import(MvcConfig.class)
public class SWebTest {
	public static void main(String[] args) {
		SpringApplication.run(SWebTest.class, args);
	}

}
