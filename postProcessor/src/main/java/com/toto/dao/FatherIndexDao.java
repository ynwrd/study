package com.toto.dao;

/**
 * 增强的父类dao 实现
 */
public class FatherIndexDao {

    public FatherIndexDao(){
        //....编写一个构造方法，打印一句话观察是否被加强了
        System.out.println("你被增强了，快去送");
    }

    public void update(){
        System.out.println("update 方法");
    }

}
