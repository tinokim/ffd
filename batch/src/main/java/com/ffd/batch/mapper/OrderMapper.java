package com.ffd.batch.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderMapper {

    @Update("UPDATE orders SET status = '배송중' WHERE status = '주문중' AND created_date = CURRENT_DATE - 1")
    void updateOrdersToShipping();

    @Update("UPDATE orders SET status = '배송완료' WHERE status = '배송중' AND created_date = CURRENT_DATE - 2")
    void updateOrdersToDelivered();
}
