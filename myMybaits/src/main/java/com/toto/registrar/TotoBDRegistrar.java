package com.toto.registrar;

import com.toto.Test;
import com.toto.dao.IndexDao;
import com.toto.factory.TotoFactoryBean;
import com.toto.service.IndexService;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.Proxy;

public class TotoBDRegistrar implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //生成一个代理对象
        System.out.println("register ....");
        BeanDefinitionBuilder bdf = BeanDefinitionBuilder.genericBeanDefinition(IndexDao.class);
        GenericBeanDefinition gbd = (GenericBeanDefinition) bdf.getBeanDefinition();
        gbd.getConstructorArgumentValues().addGenericArgumentValue(IndexDao.class.getName());
        gbd.setBeanClass(TotoFactoryBean.class);//这个bean没有构造方法参数，上面添加参数
        registry.registerBeanDefinition("indexDao",gbd);

    }
}
