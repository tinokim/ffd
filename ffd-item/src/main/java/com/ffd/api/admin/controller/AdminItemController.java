package com.ffd.api.admin.controller;

import com.ffd.api.model.Item;
import com.ffd.api.admin.service.AdminItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/items")
@RequiredArgsConstructor
@Secured("ROLE_ADMIN")
public class AdminItemController {

    private final AdminItemService adminItemService;


    @GetMapping("/list")
    public List<Item> list() {
        return adminItemService.list();
    }

    @GetMapping("/detail/{index}")
    public Item getItemDetail(@PathVariable("index") Long index) {
        return adminItemService.findDetail(index);
    }

}
