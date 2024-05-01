package com.ffd.api.admin.service;


import com.ffd.api.model.Item;

import java.util.List;

public interface    AdminItemService {

    List<Item> list();

    Item findDetail(Long index);
}


