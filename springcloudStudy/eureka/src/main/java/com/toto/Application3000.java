package com.toto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Application3000 {
    public static void main(String[] args) {
        SpringApplication.run(Application3000.class);
    }
}
