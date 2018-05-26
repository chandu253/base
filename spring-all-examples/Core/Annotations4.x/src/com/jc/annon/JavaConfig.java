package com.jc.annon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfig {

	@Bean(name= {"fmRadio"})
	@Lazy
	public Radio radio() {
		System.out.println("radio()");
		return new Radio();
	}
}






