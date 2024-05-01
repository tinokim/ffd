package com.ffd.api.admin.service.impl;

import com.ffd.common.security.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminOrderServiceImpl implements AdminOrderService {

    private final OrderMapper orderMapper;

    private final ItemMapper itemMapper;

    @Override
    public void createOrder(Long userIndex, Long itemIndex, Long stock) {
        Item item = itemMapper.findDetail(itemIndex);


        if(item != null){
            Order order = new Order();
            order.setName(item.getName());
            order.setPrice(item.getPrice());
            order.setStock(stock);
            order.setStatus("주문완료");
            order.setUser_index(userIndex);
            order.setItem_index(itemIndex);

            orderMapper.createOrder(order);
            itemMapper.decreaseStock(itemIndex, stock);
        }
    }

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
