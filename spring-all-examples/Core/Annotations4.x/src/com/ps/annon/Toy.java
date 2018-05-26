package com.ps.annon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:com/ps/annon/toy.properties")
public class Toy {
	@Value("${toyName}")
	private String toyName;
	@Value("${age}")
	private int age;

	@Override
	public String toString() {
		return "Toy [toyName=" + toyName + ", age=" + age + "]";
	}

}
