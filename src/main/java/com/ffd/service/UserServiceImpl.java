package com.ffd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.ffd.mapper.UserMapper;
import com.ffd.model.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public void signUp(User user) {
        user.setPw(encoder.encode(user.getPw()));
        user.setName(encoder.encode(user.getName()));
        user.setEmail(encoder.encode(user.getEmail()));
        user.setAddress(encoder.encode(user.getAddress()));
        userMapper.insertUser(user);
    }

    @Override
    public User login(String email, String password) {
        User user = userMapper.findByEmail(email);
        if (user != null && encoder.matches(password, user.getPw())) {
            return user;
        }
        return null;
    }

    @Override
    public void updatePassword(String id, String currentPassword, String newPassword) {
        User user = userMapper.findById(id);
        if (user != null && encoder.matches(currentPassword, user.getPw())) {
            userMapper.updateUserPassword(id, encoder.encode(newPassword));
        }
    }

    // 기타 필요한 메소드 구현...
}
