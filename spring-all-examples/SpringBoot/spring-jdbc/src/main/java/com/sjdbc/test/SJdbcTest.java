package com.sjdbc.test;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.sjdbc.bo.ContactBO;
import com.sjdbc.dao.ContactDao;

@SpringBootApplication(scanBasePackages = { "com.sjdbc.dao" }, exclude = { DataSourceAutoConfiguration.class })
public class SJdbcTest {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SJdbcTest.class, args);
		ContactDao cdao = context.getBean("contactDao", ContactDao.class);

		List<ContactBO> contacts = cdao.getContacts();
		for (ContactBO bo : contacts) {
			System.out.println(bo);
		}
	}

}
