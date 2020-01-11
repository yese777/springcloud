package com.yese;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.yese.mapper")//扫描mapper接口
@EnableEurekaClient//在服务启动后自动注册到eureka中
@EnableDiscoveryClient//Discovery团队开发获取服务的具体信息
@EnableCircuitBreaker//添加对熔断的支持(断路器)
public class Provider_Dept_Hystrix_8001_Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider_Dept_Hystrix_8001_Application.class, args);
    }

}