package com.ffd.userservice.api.admin.service.impl;

import com.ffd.userservice.api.admin.service.AdminUserService;
import com.ffd.userservice.api.mapper.UserMapper;
import com.ffd.userservice.api.model.User;
import com.ffd.userservice.common.security.role.Role;
import com.ffd.userservice.common.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUserServiceImpl implements AdminUserService {

    private final UserMapper userMapper;

    private final JwtUtil jwtUtil;

    private final TokenBlacklistService tokenBlacklistService;

    private final PasswordEncoder encoder;

    @Override
    public void signUp(User user) {
        user.setPw(encoder.encode(user.getPw()));
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setAddress(user.getAddress());
        user.setRole(Role.ADMIN.name());
        userMapper.insertUser(user);
    }

    @Override
    public void updatePassword(String id, String currentPassword, String newPassword) {
        User user = userMapper.findByEmail(id);
        if (user != null && encoder.matches(currentPassword, user.getPw())) {
            userMapper.updateUserPassword(id, encoder.encode(newPassword));
        }
    }

}