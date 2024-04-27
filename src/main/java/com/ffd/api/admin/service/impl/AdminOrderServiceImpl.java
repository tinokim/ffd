package com.ffd.api.admin.service.impl;

import com.ffd.api.model.Order;
import com.ffd.api.mapper.OrderMapper;
import com.ffd.api.admin.service.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminOrderServiceImpl implements AdminOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        return orderMapper.findOrdersByUserId(userId);
    }

    @Override
    public Order cancelOrder(Long orderId) {
        return orderMapper.updateOrderStatus(orderId, "cancelled");
    }

    @Override
    public Order returnOrder(Long orderId) {
        return orderMapper.updateOrderStatus(orderId, "returned");
    }
}
