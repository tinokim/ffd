package com.ffd.batch.service;

import com.ffd.batch.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderUpdateService {

    private final OrderMapper orderMapper;

    @Autowired
    public OrderUpdateService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Transactional
    public void updateOrderStatuses() {
        orderMapper.updateOrdersToShipping();
        orderMapper.updateOrdersToDelivered();
    }
}
