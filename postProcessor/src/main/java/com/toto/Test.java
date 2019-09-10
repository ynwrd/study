package com.toto;

import com.toto.config.AppConfig;
import com.toto.dao.FatherIndexDao;
import com.toto.interceptor.MyMethodInterceptor;
import com.toto.service.IndexService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 后置处理器，插手bean实例的生命周期
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IndexService indexService = annotationConfigApplicationContext.getBean(IndexService.class);
        indexService.query();

        System.err.println("----------------");

        //增强father类
        //cjlib 中增强父类的实现：
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(FatherIndexDao.class);
        enhancer.setCallback(new MyMethodInterceptor());
        FatherIndexDao indexDao = (FatherIndexDao) enhancer.create();
        indexDao.update();

    }
}
