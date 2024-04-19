package com.ffd.controller;

import com.ffd.model.User;
import com.ffd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        userService.signUp(user);
        return "회원가입 성공";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        User loggedInUser = userService.login(user.get("email"), user.get("password"));
        if (loggedInUser != null) {
            return "로그인 성공";
        }
        return "로그인 실패";
    }

    @PutMapping("/update-password")
    public String updatePassword(@RequestBody Map<String, String> user) {
        userService.updatePassword(user.get("email"), user.get("currentPassword"), user.get("newPassword"));
        return "비밀번호 변경 성공";
    }
}
