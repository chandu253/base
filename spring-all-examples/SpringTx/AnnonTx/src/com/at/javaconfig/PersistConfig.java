package com.at.javaconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource("db.properties")
@ComponentScan({ "com.at.dao" })
public class PersistConfig {

	@Autowired
	private Environment env;

	@Bean(name = "dataSource")
	public DataSource newDataSource() {
		DataSource dataSource = null;

		dataSource = new DriverManagerDataSource(env.getProperty("url"), env.getProperty("user"),
				env.getProperty("password"));
		return dataSource;
	}

	@Bean(name = "transactionManager", autowire = Autowire.BY_TYPE)
	public PlatformTransactionManager newTransactionManager() {
		return new DataSourceTransactionManager();
	}

	@Bean(name = "jdbcTemplate", autowire = Autowire.BY_TYPE)
	public JdbcTemplate newJdbcTemplate() {
		return new JdbcTemplate();
	}
}
