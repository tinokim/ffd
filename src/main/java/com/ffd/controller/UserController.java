package com.ffd.controller;

import com.ffd.model.User;
import com.ffd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 모든 사용자 조회
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // 특정 사용자 조회
    @GetMapping("/{userSeq}")
    public ResponseEntity<User> getUserBySeq(@PathVariable Long userSeq) {
        User user = userService.getUserBySeq(userSeq);
        return ResponseEntity.ok(user);
    }

    // 사용자 생성
    @PostMapping("/")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok().build();
    }

    // 사용자 정보 업데이트
    @PutMapping("/{userSeq}")
    public ResponseEntity<Void> updateUser(@PathVariable Long userSeq, @RequestBody User user) {
        user.setUserSeq(userSeq);
        userService.updateUser(user);
        return ResponseEntity.ok().build();
    }

    // 사용자 삭제
    @DeleteMapping("/{userSeq}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userSeq) {
        userService.deleteUser(userSeq);
        return ResponseEntity.ok().build();
    }
}
