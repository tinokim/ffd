package com.ffd.service;

import com.ffd.model.User;

public interface UserService {
    void signUp(User user);
    User login(String email, String password);
    void updatePassword(String email, String currentPassword, String newPassword);
}
