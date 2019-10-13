package com.toto.config;


//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
@ComponentScan("com")
public class AppConfig {

    @Bean
    @LoadBalanced //默认轮循环 即1-2-...1-2
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

//    @Bean //每次都随机 写在这边会影响全局，如果不想要全局，如多个服务还是不能和启动类同包名
//    public IRule iRule(){
//        return new RandomRule();//随机
//    }
}
