package com.example.mongo.dao;

import com.example.mongo.entity.UserEntity;

public interface UserDao {

    void saveUser(UserEntity userEntity);

    UserEntity findUserByUsername(String username);

    void updataUser(UserEntity userEntity);

    void deleteUserByUsername(String username);
}
