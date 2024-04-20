package com.ffd.api.controller;

import com.ffd.api.model.User;
import com.ffd.api.service.UserService;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        userService.signUp(user);
        return "회원가입 성공";
    }

//    @Secured("ROLE_ADMIN")
    @GetMapping("")
    public void test(@RequestHeader("Authorization") String token) {
        System.out.println(token);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> user) {
        String token = userService.login(user.get("email"), user.get("password"));
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        throw new AuthenticationCredentialsNotFoundException("아이디 혹은 비밀번호가 틀렸습니다.");
    }

    @PutMapping("/update-password")
    public String updatePassword(@RequestBody Map<String, String> user) {
        userService.updatePassword(user.get("email"), user.get("currentPassword"), user.get("newPassword"));
        return "비밀번호 변경 성공";
    }
}
