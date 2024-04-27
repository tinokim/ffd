package com.ffd.api.admin.controller;

import com.ffd.api.admin.service.AdminOrderService;
import com.ffd.api.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adminorders")
@RequiredArgsConstructor
@Secured("ROLE_ADMIN")
public class AdminOrderController {

    private  final AdminOrderService adminOrderService;
    // 조회
    @GetMapping("/{userId}")
    public ResponseEntity<?> getOrdersByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(adminOrderService.getOrdersByUserId(userId));
    }

    @PostMapping("/cancel/{orderId}")
    public ResponseEntity<?> cancelOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(adminOrderService.cancelOrder(orderId));
    }

    @PostMapping("/return/{orderId}")
    public ResponseEntity<?> returnOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(adminOrderService.returnOrder(orderId));
    }
}