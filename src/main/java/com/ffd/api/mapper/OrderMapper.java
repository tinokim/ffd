package com.ffd.api.mapper;

import com.ffd.api.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<Order> findOrdersByUserId(@Param("userId") Long userId);

    Order updateOrderStatus(@Param("orderId") Long orderId, @Param("status") String status);
}
