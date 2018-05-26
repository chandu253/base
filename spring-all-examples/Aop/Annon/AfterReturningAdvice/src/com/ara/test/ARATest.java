package com.ara.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ara.beans.KeyGenerator;
import com.ara.config.AppConfig;

public class ARATest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		KeyGenerator kg = context.getBean("keyGenerator", KeyGenerator.class);
		int key = kg.generateKey(7);
		System.out.println("key : " + key);
	}
}
