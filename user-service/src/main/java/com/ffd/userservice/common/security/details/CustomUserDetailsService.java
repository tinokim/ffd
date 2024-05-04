package com.ffd.userservice.common.security.details;

import com.ffd.api.mapper.UserMapper;
import com.ffd.api.model.User;
import com.ffd.common.util.AesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        AesUtil aesUtil = new AesUtil();
        User user = null;
        try {
            user = userMapper.findByEmail(aesUtil.encrypt(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (user == null) throw new UsernameNotFoundException("해당하는 유저가 없습니다.");

        return new CustomUserDetails(user);
    }
}