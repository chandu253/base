package com.pi.annon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({ @PropertySource("classpath:com/pi/annon/rectangle.properties") })
public class PJavaConfig {
	@Autowired
	private Environment env;

	@Bean
	public Rectangle rectangle() {
		Rectangle rectangle = new Rectangle();
		rectangle.setLength(Integer.parseInt(env.getProperty("length")));
		rectangle.setWidth(Integer.parseInt(env.getProperty("width")));

		return rectangle;
	}
}
