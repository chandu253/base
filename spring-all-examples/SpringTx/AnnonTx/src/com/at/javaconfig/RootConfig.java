package com.at.javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({ PersistConfig.class })
@ComponentScan({ "com.at.service", "com.at.controller" })
@EnableTransactionManagement
public class RootConfig {

}
