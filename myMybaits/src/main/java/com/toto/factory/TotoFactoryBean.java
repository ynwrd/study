package com.toto.factory;

import com.toto.Test;
import com.toto.dao.IndexDao;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TotoFactoryBean implements FactoryBean, InvocationHandler {
    Class clazz;
    TotoFactoryBean(Class clazz){
        this.clazz = clazz;
    }
    public Object getObject() throws Exception {
        Class[] clazzs = new Class[]{clazz};
        Object obj = Proxy.newProxyInstance(this.getClass().getClassLoader(),clazzs,this);
        return obj;
    }

    public Class<?> getObjectType() {
        return clazz;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理 ...");
        return null;
    }
}
