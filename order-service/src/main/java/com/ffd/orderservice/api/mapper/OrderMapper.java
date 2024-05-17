package com.ffd.orderservice.api.mapper;

import com.ffd.orderservice.api.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<Order> findOrdersByUserId(@Param("userId") Long userId);

    void createOrder(Order order);

    Order updateOrderStatus(@Param("orderId") Long orderId, @Param("status") String status);
}
