package com.toto;

import com.toto.config.Appconfig;
import com.toto.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 spring 4 采用的是jcl,工作机制是中间键
 spring 5 采用的是jcl，但把jcl改了，默认使用jcl，当项目存在slf4j或者其它的日志时。使用class.forName去实例化返回日志实现
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
        IndexService indexService = annotationConfigApplicationContext.getBean(IndexService.class);
        indexService.query();
    }
}
