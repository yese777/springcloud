package com.yese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//EurekaServer服务端
public class Config_Eureka_Server_7001_Application {
    public static void main(String[] args) {
        SpringApplication.run(Config_Eureka_Server_7001_Application.class, args);
    }
}
