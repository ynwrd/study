package com.toto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApplicationUser {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationUser.class);
    }
}
