package com.yese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient//ribbon和eureka整合以后,客户端可以直接调用,不用关心ip地址和端口号
@EnableFeignClients(basePackages = {"com.yese"})
public class Consumer_Dept_Feign_8080_application {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_Dept_Feign_8080_application.class, args);
    }

}
