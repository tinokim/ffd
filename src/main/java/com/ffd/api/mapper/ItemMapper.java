package com.ffd.api.mapper;

import com.ffd.api.model.Item;
import com.ffd.api.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {

    Item findList();

    Item findDetail();

}