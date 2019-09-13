package com.toto;

import com.toto.config.AppConfig;
import com.toto.service.RoomService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 在使用mybatis时增加打印sql日志
 */
public class Test {
    public static void main(String[] args) {
//        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        RoomService roomService = annotationConfigApplicationContext.getBean(RoomService.class);
        System.out.println(roomService.getRoomList());
    }
}
