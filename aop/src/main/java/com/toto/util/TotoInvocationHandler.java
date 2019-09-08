package com.toto.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TotoInvocationHandler implements InvocationHandler {

    /**
     * 目标对象
     */
    private Object target;
    public TotoInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy  代理对象
     * @param method 代理目标方法
     * @param args  目标参数
     * @return  目标返回值
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理开始... proxy...");
        return method.invoke(target,args);
    }
}
