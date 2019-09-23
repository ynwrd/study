package com.toto.observer;

public class Test {
    public static void main(String[] args) {
        //启动观察者模式：1.需要先拥有观察者和被观察者
        //              2.把观察者加入到被观察者中
        //              3.被观察者状态变更
        Master master = new Master();
        master.addObserver(new TotoWatchUser());//懒人观察者角色加入被观察者
        master.addObserver(new WatchUser("boss"));
        WatchUser baseStaff = new WatchUser("baseStaff");
        master.addObserver(baseStaff);//将其它的观察者角色也加入到被观察者中
        master.chufajingbao();
    }
}
