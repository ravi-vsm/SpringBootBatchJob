package com.deloitte.employeebatchjob.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author RAVI YARAMATI
 *
 */
@Configuration
public class DbConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(DbConfig.class);
	
	@Value("com.deloitte.mySqlDbUrl")
	private String mySqlDbUrl;
	
	@Value("com.deloitte.mySqlDbUserName")
	private String mySqlDbUserName;
	
	@Value("com.deloitte.mySqlDbPassword")
	private String mySqlDbPassword;
	
	@Value("com.deloitte.mySql.driver-class-name")
	private String mySqlDriverClassName;
	
	
	@Value("com.deloitte.oracleDbUrl")
	private String oracleDbUrl;
	
	@Value("com.deloitte.oracleDbUserName")
	private String oracleDbUserName;
	
	@Value("com.deloitte.oracleDbPassword")
	private String oracleDbPassword;
	
	@Value("com.deloitte.oracle.driver-class-name")
	private String oracleDriverClassName;
	
	@Primary
	@Bean("mySqlDataSource")
	public DataSource getMySqlDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(mySqlDbUrl);
		dataSource.setUsername(mySqlDbUserName);
		dataSource.setPassword(mySqlDbPassword);
		dataSource.setDriverClassName(mySqlDriverClassName);
		
		logger.info("DbConfig : getMySqlDataSource() : {}.", dataSource);
		return dataSource;
	}
	
	@Bean("oracleDataSource")
	public DataSource getOracleDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(oracleDbUrl);
		dataSource.setUsername(oracleDbUserName);
		dataSource.setPassword(oracleDbPassword);
		dataSource.setDriverClassName(oracleDriverClassName);
		
		logger.info("DbConfig : getOracleDataSource() : {}.", dataSource);
		return dataSource;
	}
	
	@Bean("mySqlJdbcTemplate")
	public JdbcTemplate getMySqlJdbcTemplate(@Qualifier("mySqlDataSource") DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
	
	@Bean("oracleJdbcTemplate")
	public JdbcTemplate getOracleJdbcTemplate(@Qualifier("oracleDataSource") DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
		

}
