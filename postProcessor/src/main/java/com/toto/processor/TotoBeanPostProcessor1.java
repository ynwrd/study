package com.toto.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class TotoBeanPostProcessor1 implements BeanPostProcessor,PriorityOrdered {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("indexService")){
            System.out.println("register indexService 1 ...");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("indexService")){
            System.out.println("register indexService 1 ... success");
        }
        return bean;
    }

    public int getOrder() {
        return 200;
    }
}
