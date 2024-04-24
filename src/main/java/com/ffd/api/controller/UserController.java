package com.ffd.api.controller;

import com.ffd.api.model.User;
import com.ffd.api.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && !authorizationHeader.isEmpty()) {
            String token = authorizationHeader.substring("Bearer ".length());
            userService.logout(token);
            return ResponseEntity.ok("로그아웃 되었습니다.");
        }
        return ResponseEntity.badRequest().body("로그아웃 실패.");
    }

    @PutMapping("/update-password")
    public String updatePassword(@RequestBody Map<String, String> user) {
        userService.updatePassword(user.get("email"), user.get("currentPassword"), user.get("newPassword"));
        return "비밀번호 변경 성공";
    }
}
