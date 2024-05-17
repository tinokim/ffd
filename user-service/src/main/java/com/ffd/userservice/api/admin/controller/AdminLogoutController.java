package com.ffd.userservice.api.admin.controller;

import com.ffd.userservice.api.admin.service.AdminLogoutService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/logout")
@RequiredArgsConstructor
public class AdminLogoutController {

    private final AdminLogoutService adminLogoutService;

    @PostMapping("")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && !authorizationHeader.isEmpty()) {
            String token = authorizationHeader.substring("Bearer ".length());
            adminLogoutService.logout(token);
            return ResponseEntity.ok("로그아웃 되었습니다.");
        }
        return ResponseEntity.badRequest().body("로그아웃 실패.");
    }
}
