package com.yese;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.yese.mapper")//扫描mapper接口
@EnableDiscoveryClient//Discovery团队开发获取服务的具体信息
@EnableEurekaClient//ribbon和eureka整合以后,客户端可以直接调用,不用关心ip地址和端口号
@EnableCircuitBreaker//添加对熔断的支持(断路器)
public class Provider_Dept_Hystrix_8001_Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider_Dept_Hystrix_8001_Application.class, args);
    }

    //Hystrix监控
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }
}