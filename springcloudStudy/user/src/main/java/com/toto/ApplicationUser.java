package com.toto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@RibbonClients({@RibbonClient(name = "ORDER-SERVICE",configuration = com.config.OrderRuleConfig.class)})
@EnableFeignClients
public class ApplicationUser {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationUser.class);
    }
}
