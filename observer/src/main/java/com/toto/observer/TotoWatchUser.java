package com.toto.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者角色2：懒人，但观察了还是愿意做一下事情的
 */
public class TotoWatchUser implements Observer {

    public void update(Observable o, Object arg) {
        System.out.println("有人告诉我出事了，但有一线人员，我要相信他们的能力");
    }
}
