package com.toto.service;

import com.toto.dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class IndexService {
    @Autowired
    private IndexDao indexDao;

    public IndexService() {
        System.out.println("regist indexService");
    }
    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    public void query(){
        indexDao.query();
    }
}
