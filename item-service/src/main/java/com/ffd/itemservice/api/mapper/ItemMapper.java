package com.ffd.itemservice.api.mapper;

import com.ffd.itemservice.api.model.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

    List<Item> findList();

    Item findDetail(Long index);

    void decreaseStock(Long itemIndex, Long stock);
}