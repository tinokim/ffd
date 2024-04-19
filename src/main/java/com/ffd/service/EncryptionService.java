package com.ffd.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public String encrypt(String plainText) {
        return bCryptPasswordEncoder.encode(plainText);
    }
}
