package com.toto.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class IndexDaoImpl implements IndexDao {

    public void query() {
//        System.out.println(this.getClass().hashCode());//获取这个对象的code
        System.out.println(" indexDao query...");
    }
}
