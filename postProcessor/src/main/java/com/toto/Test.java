package com.toto;

import com.toto.config.AppConfig;
import com.toto.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IndexService indexService = annotationConfigApplicationContext.getBean(IndexService.class);
        indexService.query();
    }
}
