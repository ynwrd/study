package com.toto.service;

import com.toto.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public void query(){
        System.out.println("user print by service");
        userDao.queryList();
    }
    public void query(String ak47,String OO7){
        System.out.println(OO7+"拿着"+ak47+"去运行");
        userDao.queryList();
    }
}
