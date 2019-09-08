package com.toto.service;

import com.toto.dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
    @Autowired
    private IndexDao indexDao;

    public String getId(){
        System.out.println("service 调用....");
        return indexDao.getNameById("id");
    }
}
