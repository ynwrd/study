package com.toto.dao;

import org.springframework.stereotype.Repository;

@Repository
public class IndexDaoImpl implements IndexDao {


    public void query() {
        System.out.println("query");
    }
}
