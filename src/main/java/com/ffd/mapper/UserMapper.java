package com.ffd.mapper;

import com.ffd.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insertUser(User user);
    User findByEmail(String email);
    void updateUserPassword(String id, String newPassword);
    User findById(String id);
}