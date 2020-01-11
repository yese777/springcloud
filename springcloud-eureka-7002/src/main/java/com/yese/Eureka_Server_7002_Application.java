package com.yese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer//EurekaServer服务端
public class Eureka_Server_7002_Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka_Server_7002_Application.class, args);
    }
}
