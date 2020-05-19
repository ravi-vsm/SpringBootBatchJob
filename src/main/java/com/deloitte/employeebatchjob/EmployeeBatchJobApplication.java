package com.deloitte.employeebatchjob;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableBatchProcessing
@SpringBootApplication
public class EmployeeBatchJobApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeBatchJobApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeBatchJobApplication.class, args);
		logger.info("Sample Spring Boot Batch Applciation");
	}

}
