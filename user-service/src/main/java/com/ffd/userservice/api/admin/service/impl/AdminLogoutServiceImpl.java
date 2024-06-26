package com.ffd.userservice.api.admin.service.impl;

import com.ffd.userservice.api.admin.service.AdminLogoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminLogoutServiceImpl implements AdminLogoutService {

    private final TokenBlacklistService tokenBlacklistService;

    @Override
    public void logout(String token) {
        // 토큰 무효화 로직
        tokenBlacklistService.blacklistToken(token);
    }

}