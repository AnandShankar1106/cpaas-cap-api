package com.sinch.cpass.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource({ "classpath:application-dev.yml" })
public class SalesOrderConfig {

	private static final String URL = "spring.salesorder.datasource.jdbcUrl";
	private static final String USER = "spring.salesorder.datasource.username";
	private static final String PASSWORD = "spring.salesorder.datasource.password";
	private static final String DRIVER = "spring.salesorder.datasource.driverClassName";

	@Bean(name = "salesOrderDataSource")
	DataSource dataSource(@Autowired Environment env) {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(env.getProperty(URL));
		driverManagerDataSource.setUsername(env.getProperty(USER));
		driverManagerDataSource.setPassword(env.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(env.getProperty(DRIVER));		
		return driverManagerDataSource;
	}
}
