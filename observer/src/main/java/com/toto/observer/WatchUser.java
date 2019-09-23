package com.toto.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者用户:实现一个Observer类，里面有一个update方法
 * 这是一个观察者类
 */
public class WatchUser implements Observer {

    /**
     * 观察者的名称，相同角色的观察者拥有不同的名字
     */
    private String name;

    public WatchUser(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(Observable o, Object arg) {
        //如果被观察者状态改变，观察者能在第一时间接受到通知
        System.out.println(name+"接受到了通知，并第一时间待命，毕竟我们是一线观察者");
    }
}
