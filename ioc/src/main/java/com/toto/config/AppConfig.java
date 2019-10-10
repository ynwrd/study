package com.toto.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import javax.xml.transform.sax.TemplatesHandler;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

/**
 * Configuration加与不加的区别：
 *  加了使用这个类变成一个代理类，并且类实现为单例，但如果@bean的实现方法为静态则为原型，非静态方法使用cjlib进行增强，调用父类的方法，如果是new时则从容器中拿，如果没有才创建
 *  不加则这个类变成一个普通类，类实现为单例，但会出现多次new的情况，因为spring没用使用cjlib进行增强该类，不能判断新增的场景而只能靠我们的方法去新增
 */
@Configuration
@ComponentScan("com.toto")
public class AppConfig {

    @Bean
    @Autowired
    public SqlSessionFactory getSqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
        ssf.setDataSource(dataSource);
        return ssf.getObject();
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/test");
        ds.setPassword("root");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        return ds;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }



}
