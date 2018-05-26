package com.jcaw.annon;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigAutoWire {
	@Bean(name = "andriod", autowire = Autowire.BY_TYPE)
	public Robot robot() {
		return new Robot();
	}

	@Bean
	public Chip i5Chip() {
		return new Chip();
	}

	@Bean
	public Chip i7Chip() {
		return new Chip();
	}
}
