package com.ffd.userservice.api.admin.service;

import com.ffd.api.model.Item;
import com.ffd.api.model.Order;

import java.util.List;

public interface AdminOrderService {

    List<Order> getOrdersByUserId(Long userId);

    void createOrder(Long userIndex, Long itemIndex, Long stock);

    Order cancelOrder(Long orderId);

    Order returnOrder(Long orderId);
}
