package com.ffd.api.admin.service.impl;

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