package com.toto.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class AppCOnfig {

    @Bean
    @LoadBalanced //加入这行就会自动使用Ribbon服务
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
