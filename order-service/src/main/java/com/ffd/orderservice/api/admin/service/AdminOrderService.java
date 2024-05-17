package com.ffd.orderservice.api.admin.service;

import com.ffd.orderservice.api.model.Order;

import java.util.List;

public interface AdminOrderService {

    List<Order> getOrdersByUserId(Long userId);

    void createOrder(Long userIndex, Long itemIndex, Long stock);

    Order cancelOrder(Long orderId);

    Order returnOrder(Long orderId);
}
