package com.ffd.batch.scheduler;

import com.ffd.batch.service.OrderUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class OrderUpdateScheduler {

    private final OrderUpdateService orderUpdateService;

    @Autowired
    public OrderUpdateScheduler(OrderUpdateService orderUpdateService) {
        this.orderUpdateService = orderUpdateService;
    }

    @Scheduled(cron = "0 0 9 * * ?")
    public void updateOrderStatuses() {
        orderUpdateService.updateOrderStatuses();
    }
}
