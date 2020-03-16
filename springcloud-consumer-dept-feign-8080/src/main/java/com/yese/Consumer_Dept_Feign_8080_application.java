package com.yese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.yese"})
public class Consumer_Dept_Feign_8080_application {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_Dept_Feign_8080_application.class, args);
    }

}
