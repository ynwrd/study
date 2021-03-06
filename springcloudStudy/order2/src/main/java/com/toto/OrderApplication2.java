package com.toto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication2.class);
    }
}
