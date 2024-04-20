package com.ffd.api.service.impl;

import com.ffd.api.service.UserService;
import com.ffd.common.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ffd.api.mapper.UserMapper;
import com.ffd.api.model.User;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final JwtUtil jwtUtil;

    private final PasswordEncoder encoder;

    @Override
    public void signUp(User user) {
        user.setPw(encoder.encode(user.getPw()));
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setAddress(user.getAddress());
        userMapper.insertUser(user);
    }

    @Override
    public String login(String email, String password) {
        User user = userMapper.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("이메일이 존재하지 않습니다.");
        }

        // 암호화된 password를 디코딩한 값과 입력한 패스워드 값이 다르면 null 반환
        if(!encoder.matches(password, user.getPw())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        return jwtUtil.createAccessToken(user);
    }

    @Override
    public void updatePassword(String id, String currentPassword, String newPassword) {
        User user = userMapper.findByEmail(id);
        if (user != null && encoder.matches(currentPassword, user.getPw())) {
            userMapper.updateUserPassword(id, encoder.encode(newPassword));
        }
    }

    // 기타 필요한 메소드 구현...
}
