package com.yese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication
@EnableHystrixDashboard//Dashboard开启监控页面
public class Hystrix_Dashboard_9001_Application {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix_Dashboard_9001_Application.class, args);
    }
}
