package com.toto.observer;

import java.util.Observable;

/**
 * 观察者模式学习：观察者包括 被观察者 和观察者 两种角色
 * 观察者可以为多个，被观察者只有一个
 * jdk中的实现：被观察者实现Observable 这个class
 * 观察者实现Observe
 * 观察者模式与现实中的观察者恰恰相反：现实中的观察者一直盯着屏幕并且观察你，
 * 但观察者模式中被观察者持有观察者引用，当事件发生时，将会通知到所有的观察者
 * 特点：1.被观察者持有观察者的引用
 *      2.被观察者可以删除/新增观察者
 *      3.被观察者的状态更改后，要通知到所有的观察者
 */
public class Master extends Observable {

    /**
     * 触发了警报:即修改了状态，需要通知到所有的观察者
     */
    public void chufajingbao(){
        setChanged();//开关
        notifyObservers();//通知所有的观察者
    }
}
