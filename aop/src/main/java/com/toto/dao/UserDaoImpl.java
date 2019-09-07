package com.toto.dao;


import com.toto.entity.UserEntity;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<UserEntity> queryList() {
        System.out.println("2333");
        return null;
    }

    public UserEntity selectById() {
        return null;
    }
}
