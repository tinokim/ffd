package com.ffd.userservice.api.admin.controller;

import com.ffd.userservice.api.admin.service.AdminUserService;
import com.ffd.userservice.api.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class AdminUserController {

    private final AdminUserService adminUserService;

    @PostMapping("")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        adminUserService.signUp(user);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PutMapping("/update-password")
    public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> user) {
        adminUserService.updatePassword(user.get("email"), user.get("currentPassword"), user.get("newPassword"));
        return ResponseEntity.ok("비밀번호 변경 성공");
    }

}
