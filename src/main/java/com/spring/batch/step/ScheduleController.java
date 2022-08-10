package com.spring.batch.step;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class ScheduleController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @GetMapping
    public BatchStatus schedule() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        Map<String, JobParameter> jobParameterMaps = new HashMap<>();
        jobParameterMaps.put("time", new JobParameter(System.currentTimeMillis()));

        JobParameters parameters = new JobParameters(jobParameterMaps);
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        System.out.println("Job Execution:" + jobExecution.getStatus());
        System.out.println("Batch is running ..");
        while (jobExecution.isRunning()) {
            System.out.println("...");
        }
        return jobExecution.getStatus();
    }
}