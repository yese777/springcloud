package com.yese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer//开启
public class Config_Server_3344_Application {
    public static void main(String[] args) {
        SpringApplication.run(Config_Server_3344_Application.class, args);
    }
}
