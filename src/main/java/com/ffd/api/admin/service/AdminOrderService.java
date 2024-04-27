package com.ffd.api.admin.service;

import com.ffd.api.model.Item;
import com.ffd.api.model.Order;

import java.util.List;

public interface AdminOrderService {

    List<Order> getOrdersByUserId(Long userId);

    Order cancelOrder(Long orderId);

    Order returnOrder(Long orderId);
}
