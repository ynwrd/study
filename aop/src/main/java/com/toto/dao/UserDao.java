package com.toto.dao;

import com.toto.entity.UserEntity;

import java.util.List;


public interface UserDao {
    List<UserEntity> queryList();

    UserEntity selectById();
}
