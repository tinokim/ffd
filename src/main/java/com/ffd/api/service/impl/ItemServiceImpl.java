package com.ffd.api.service.impl;

import com.ffd.api.mapper.ItemMapper;
import com.ffd.api.model.Item;
import com.ffd.api.model.User;
import com.ffd.api.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    @Override
    public Item findDetail(Long index) {
        Item item = itemMapper.findDetail();
        return item;
    }

    private final ItemMapper itemMapper;

    @Override
    public List<Item> list() {
        List<Item> ItemList = (List<Item>) itemMapper.findList();
        return ItemList;
    }
}