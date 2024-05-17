package com.ffd.batch.config;

import com.ffd.batch.util.OrdersStatusUpdateTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

/*
@Configuration
@EnableBatchProcessing
public class BatchJobConfig {

    // Spring Batch 5.x에서는 JobBuilderFactory와 StepBuilderFactory를 직접 주입받는 방식이 변경될 수 있습니다.
    // 아래 예시는 Spring Batch 4.x의 방식을 따르고 있으며, Spring Batch 5.x의 새로운 방법으로 업데이트가 필요합니다.

    @Bean
    public Job ordersStatusUpdateJob(JobBuilderFactory jobBuilderFactory, Step updateOrdersStatusStep) {
        return jobBuilderFactory.get("ordersStatusUpdateJob")
                .start(updateOrdersStatusStep)
                .build();
    }

    @Bean
    public Step updateOrdersStatusStep(StepBuilderFactory stepBuilderFactory, OrdersStatusUpdateTasklet tasklet) {
        return stepBuilderFactory.get("updateOrdersStatusStep")
                .tasklet(tasklet)
                .build();
    }

    @Bean
    public OrdersStatusUpdateTasklet ordersStatusUpdateTasklet() {
        // Tasklet Bean 정의
        return new OrdersStatusUpdateTasklet();
    }
}*/
