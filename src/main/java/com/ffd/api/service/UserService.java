package com.ffd.api.service;

import com.ffd.api.model.User;

public interface UserService {
    void signUp(User user);

    User findEmail(String email);

    String login(String email, String password);

    void updatePassword(String email, String currentPassword, String newPassword);

    void logout(String token);
}
