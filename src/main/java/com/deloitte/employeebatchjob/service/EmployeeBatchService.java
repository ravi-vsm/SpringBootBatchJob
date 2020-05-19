package com.deloitte.employeebatchjob.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author RAVI YARAMATI
 *
 */
@Service
public class EmployeeBatchService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeBatchService.class);
	
	@Autowired
	private Job job;
	
	@Autowired
	private SimpleJobLauncher simpleJobLauncher;
	
	public void processBatchJob() {
		
		JobExecution execution = null;
		
		logger.info("Employee Batch Job : Running ........");
		
		JobParameters param = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis()))
				.addString("id", "ABCD1234").toJobParameters();
		
		try {
			
			execution = simpleJobLauncher.run(job, param);
			
		} catch(Exception e) {
			logger.error("Excepton Root Cause : {}.", e.getMessage());
		}

	}

}
