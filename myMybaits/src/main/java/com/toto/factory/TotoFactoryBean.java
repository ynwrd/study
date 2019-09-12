package com.toto.factory;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.FactoryBean;

import java.lang.annotation.Annotation;
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
        /**
         * 在代理类中实现业务：
         * 1.获取接口写的interface
         * 2.获取@select、@update、...里面的sql语句
         */
        System.out.println("代理类 ...我是一个工具人");
        Annotation[] annotations =  method.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if(annotation instanceof Select){
                String value = ((Select) annotation).value()[0];
                System.out.println(value);
                //...执行查询的语句
            }else if(annotation instanceof Update){
                System.out.println(((Update) annotation).value()[0]);
            }
            //...
        }
        //...根据类型返回封装值
        System.out.println(method.getReturnType());
        if("void".equals(method.getReturnType().getName())){
            return null;
        }else if("int".equals(method.getReturnType().getName())){
            return 233;
        }
        return "toto";
    }
}
