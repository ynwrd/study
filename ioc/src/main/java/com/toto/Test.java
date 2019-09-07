package com.toto;

import com.toto.config.AppConfig;
import com.toto.service.IndexService;
import com.toto.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);
//        userService.query();
        IndexService indexService = annotationConfigApplicationContext.getBean(IndexService.class);
        indexService.query();
        IndexService indexService1 = annotationConfigApplicationContext.getBean(IndexService.class);
        indexService1.query();
    }
}
