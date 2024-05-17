package com.ffd.userservice.api.admin.service.impl;

import com.ffd.userservice.api.admin.service.AdminLoginService;
import com.ffd.userservice.api.mapper.UserMapper;
import com.ffd.userservice.api.model.User;
import com.ffd.userservice.common.util.AesUtil;
import com.ffd.userservice.common.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminLoginServiceImpl implements AdminLoginService {

    private final UserMapper userMapper;

    private final JwtUtil jwtUtil;

    private final TokenBlacklistService tokenBlacklistService;

    private final PasswordEncoder encoder;

    @Override
    public String login(String email, String password) throws Exception {
        AesUtil aesUtil = new AesUtil();
        User user = userMapper.findByEmail(aesUtil.encrypt(email));
        if(user == null) {
            throw new UsernameNotFoundException("이메일이 존재하지 않습니다.");
        }

        // 암호화된 password를 디코딩한 값과 입력한 패스워드 값이 다르면 null 반환
        if(!encoder.matches(password, user.getPw())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        return jwtUtil.createAccessToken(user);
    }

}