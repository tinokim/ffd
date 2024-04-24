package com.ffd.api.controller;

import com.ffd.api.model.Item;
import com.ffd.api.model.User;
import com.ffd.api.service.ItemService;
import com.ffd.api.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;


    @GetMapping("/list")
    public List<Item> list() {
        return itemService.list();
    }

    @GetMapping("/detail/{index}")
    public Item getItemDetail(@PathVariable("index") Long index) {
        return itemService.findDetail(index);
    }

}
