package com.toto;

import com.toto.config.AppConfig;
import com.toto.service.RoomService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(annotationConfigApplicationContext.getBean(RoomService.class).getRoomList());
    }
}
