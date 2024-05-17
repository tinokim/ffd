package com.ffd.batch.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableScheduling
public class BatchSchedulerConfig {

    private final JobLauncher jobLauncher;
    private final Job ordersStatusUpdateJob;

    @Autowired
    public BatchSchedulerConfig(JobLauncher jobLauncher, Job ordersStatusUpdateJob) {
        this.jobLauncher = jobLauncher;
        this.ordersStatusUpdateJob = ordersStatusUpdateJob;
    }

    @Scheduled(cron = "0 0 9 * * ?") // 매일 아침 9시
    public void runJob() {
        try {
            jobLauncher.run(ordersStatusUpdateJob, new JobParametersBuilder()
                    .addDate("date", new Date())
                    .toJobParameters());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
