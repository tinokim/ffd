package com.ffd.userservice.api.admin.controller;

import com.ffd.userservice.api.admin.service.AdminLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin/login")
@RequiredArgsConstructor
public class AdminLoginController {

    private final AdminLoginService adminLoginService;

    @PostMapping("")
    public ResponseEntity<String> login(@RequestBody Map<String, String> user) throws Exception {
        String token = adminLoginService.login(user.get("email"), user.get("password"));
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        throw new AuthenticationCredentialsNotFoundException("아이디 혹은 비밀번호가 틀렸습니다.");
    }

}
