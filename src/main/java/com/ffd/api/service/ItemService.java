package com.ffd.api.service;


import com.ffd.api.model.Item;
import com.ffd.api.model.User;

import java.util.List;

public interface ItemService {

    List<Item> list();

    Item findDetail(Long index);
}


