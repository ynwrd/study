package com.toto.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置管理器，可以插手生命周期
 */
@Component
public class TotoBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("indexService")){
            System.out.println("register indexService 0 ...");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("indexService")){
            System.out.println("register indexService 0 ... success");
        }
        return bean;
    }
}
