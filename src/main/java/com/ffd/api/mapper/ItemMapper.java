package com.ffd.api.mapper;

import com.ffd.api.model.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

    List<Item> findList();

    Item findDetail(Long index);

}