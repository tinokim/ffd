package com.ffd.userservice.api.mapper;

import com.ffd.userservice.api.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    void insertUser(@Param("user") User user);

    User findByEmail(@Param("email") String email);

    void updateUserPassword(@Param("id") String id, @Param("newPassword") String newPassword);

}