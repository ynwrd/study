package com.toto;

import com.toto.config.Appconfig;
import com.toto.dao.IndexDao;
import com.toto.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 问题：如何直接注入一个接口到service中呢？
 * 需要：第一步将接口代理，第二部注入到bd容器中
 */
public class Test {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
        IndexService indexDao = annotationConfigApplicationContext.getBean(IndexService.class);
        indexDao.getId();
    }
}
