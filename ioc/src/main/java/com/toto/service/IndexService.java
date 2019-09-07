package com.toto.service;

import com.toto.dao.IndexDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class IndexService implements ApplicationContextAware {
    //实现原型
    private static ApplicationContext applicationContext;

    //service 是单例，dao是原型
    public void query(){
        IndexDao indexDao = (IndexDao) applicationContext.getBean("indexDaoImpl");
        System.out.println(indexDao.hashCode());
        indexDao.query();
    }
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext =applicationContext;
    }


}
