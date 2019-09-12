package com.toto.config;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.toto")
@MapperScan("com.toto.mapper")
public class AppConfig {


    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dmds = new DriverManagerDataSource();
        dmds.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=true&autoReconnect=true&pinGlobalTxToPhysicalConnection=true&serverTimezone=Asia/Shanghai");
        dmds.setUsername("root");
        dmds.setPassword("");
        dmds.setDriverClassName("com.mysql.jdbc.Driver");
        return dmds;
    }

    @Bean
    public SqlSessionFactoryBean sessionFactoryBean(){
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setDataSource(getDataSource());//使用了@configuration以后这个方法被代理了，所以可以不用方法来注入
        return ssfb;
    }

}
