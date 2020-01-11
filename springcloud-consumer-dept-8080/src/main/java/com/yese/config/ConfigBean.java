package com.yese.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration//相当于原来的applicationContext.xml,在这个类里面配bean
public class ConfigBean {

    @Bean
    @LoadBalanced//ribbon,配置负载均衡
    //RoundRobinRule:轮询(默认)
    //RandomRule:随机
    //RetryRule:先轮询,如果服务获取失败,则会在指定的时间内进行重试
    //AvailabilityFilteringRule:先过滤掉跳闸的服务,对剩下的进行轮询
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
