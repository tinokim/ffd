package com.ffd.orderservice.api.admin.service.impl;

//import com.ffd.common.security.role.Role;
import com.ffd.orderservice.api.admin.service.AdminOrderService;
import com.ffd.orderservice.api.admin.service.ItemClient;
import com.ffd.orderservice.api.mapper.OrderMapper;
import com.ffd.orderservice.api.model.Item;
import com.ffd.orderservice.api.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminOrderServiceImpl implements AdminOrderService {

    private final OrderMapper orderMapper;

    private final ItemClient itemClient;

    @Override
    public void createOrder(Long userIndex, Long itemIndex, Long stock) {
        Item item = itemClient.findDetail(itemIndex);


        if(item.getStock() >=  stock){
            Order order = new Order();
            order.setName(item.getName());
            order.setPrice(item.getPrice());
            order.setStock(stock);
            order.setStatus("주문완료");
            order.setUser_index(userIndex);
            order.setItem_index(itemIndex);

            orderMapper.createOrder(order);
            itemClient.decreaseStock(itemIndex, stock);
        }else{
            throw new RuntimeException("재고가 부족합니다.");
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
