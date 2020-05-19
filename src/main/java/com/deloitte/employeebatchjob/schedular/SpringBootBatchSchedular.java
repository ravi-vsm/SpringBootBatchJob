package com.deloitte.employeebatchjob.schedular;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.deloitte.employeebatchjob.service.EmployeeService;

@Component
public class SpringBootBatchSchedular {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringBootBatchSchedular.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@Scheduled(cron = "0 0 20 * * *", zone = "CST")
	public void taskSchedular() {
		logger.info("Spring Boot Batch Job : taskSchedular : STARTED...");
		
		logger.info("Spring Boot Batch Job : taskSchedular : COMPLETED...");
		
	}

}
