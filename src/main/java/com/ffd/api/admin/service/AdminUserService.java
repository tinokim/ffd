package com.ffd.api.admin.service;

import com.ffd.api.model.User;

public interface AdminUserService {
    void signUp(User user);

    void updatePassword(String email, String currentPassword, String newPassword);

}
