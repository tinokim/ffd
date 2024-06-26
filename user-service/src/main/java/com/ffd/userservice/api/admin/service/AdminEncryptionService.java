package com.ffd.userservice.api.admin.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminEncryptionService {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public String encrypt(String plainText) {
        return bCryptPasswordEncoder.encode(plainText);
    }
}
