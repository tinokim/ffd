package com.ffd.batch.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    void updateOrdersToShipping();
    void updateOrdersToDelivered();
}
