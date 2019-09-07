package com.toto;

import com.toto.config.AppConfig;
import com.toto.dao.UserDao;
import com.toto.dao.UserDaoImpl;
import com.toto.service.UserService;
import com.toto.util.TotoInvocationHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);
//        userService.query();
        UserDao userDao = (UserDao) Proxy.newProxyInstance(Test.class.getClassLoader(),new Class[]{UserDao.class},new TotoInvocationHandler(new UserDaoImpl()));
        userDao.queryList();
    }
}
