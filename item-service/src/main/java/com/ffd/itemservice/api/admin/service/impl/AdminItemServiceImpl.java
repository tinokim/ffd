package com.ffd.itemservice.api.admin.service.impl;

import com.ffd.itemservice.api.admin.service.AdminItemService;
import com.ffd.itemservice.api.mapper.ItemMapper;
import com.ffd.itemservice.api.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminItemServiceImpl implements AdminItemService {

    private final ItemMapper itemMapper;

    @Override
    public List<Item> list() {
        return itemMapper.findList();
    }

    @Override
    public Item findDetail(Long index) {
        return itemMapper.findDetail(index);
    }

}