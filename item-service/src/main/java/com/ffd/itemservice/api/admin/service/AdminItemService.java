package com.ffd.itemservice.api.admin.service;


import com.ffd.itemservice.api.model.Item;

import java.util.List;

public interface    AdminItemService {

    List<Item> list();

    Item findDetail(Long index);
}


