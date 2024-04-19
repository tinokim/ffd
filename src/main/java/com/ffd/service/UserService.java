package com.ffd.service;

import com.ffd.model.User;

import java.util.List;

public interface UserService {
    User getUserBySeq(Long userSeq);
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Long userSeq);
}
