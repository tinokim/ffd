package com.ffd.orderservice.api.admin.controller;

import com.ffd.orderservice.api.admin.service.AdminOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/orders")
@RequiredArgsConstructor
//@Secured("ROLE_ADMIN")
public class AdminOrderController {

    private  final AdminOrderService adminOrderService;
    // 조회
    @GetMapping("/{userId}")
    public ResponseEntity<?> getOrdersByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(adminOrderService.getOrdersByUserId(userId));
    }

    @PostMapping("")
    public ResponseEntity<?> postOrder(@RequestParam("userIndex") Long userIndex, @RequestParam("itemIndex") Long itemIndex, @RequestParam("stock") Long stock) {
        adminOrderService.createOrder(userIndex, itemIndex, stock);
        return ResponseEntity.ok(null);
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
