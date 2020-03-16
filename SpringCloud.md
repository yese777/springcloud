# 演化

三层架构：MVC，架构的本质是为了解耦

开发框架：Spring
Spring的核心：IOC和AOP
IOC：控制反转
AOP：切面（本质，动态代理）。在不影响业务本来的情况下，实现动态增加功能

spring是一个轻量级的Java开源框架，容器
目的：解决企业开发的复杂性问题
但是配置文件十分复杂

SpringBoot就是 Spring的升级版
是新一代 JavaEE的开发标准，开箱即用！
它自动帮我们配置了非常多的东西，拿来即用！
特性：约定大于配置

微服务架构-->新架构
模块化，功能化！

用户越来越多：一台服务器解决不了；再增加服务器！横向
假设A服务器占用98%资源，B服务器只占用了10%：负载均衡机制
将原来的整体项目，分成模块化，用户就是一个单独的项目，评论也是一个单独的项目，项目和项目之前需要通信，如何通信？
用户非常多，而评论十分少！给用户多一点服务器，给评论少一点服务器

微服务架构分布式架构会遇到的四个核心问题？
1.这么多服务，客户端该如何去访问？
2.这么多服务，服务之间如何进行通信？
3.这么多服务，如何管理？
4.服务挂了，怎么办？

解决方案
Springcloud，是一套生态，就是来解决以上分布式架构的4个问题
想使用 Springcloud，必须要掌握 SpringBoot，因为 Springcloud是基于 SpringBoot

本质上要解决的问题：
1.API网关，服务路由
2.HTTP，RPC框架，异步调用
3.服务注册与发现，高可用
4.熔断机制，服务降级

为什么要解决这些问题？本质：网络是不可靠的



# 常见面试题

什么是微服务？
微服务之间是如何独立通讯的？
SpringCloud和 Dubbo有哪些区别？
Springboot和 Spring Cloud，请你谈谈对他们的理解
什么是服务熔断？什么是服务降级
微服务的优缺点是分别是什么？说下你在项目开发中遇到的坑
你所知道的微服务技术栈有哪些？请列举一二
eureka和 zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？

# 理论

###### 微服务

由Martin Fowler提出

强调的是服务的大小，他关注的是某一个点，是具体解决某一个问题/提供落地对应服务的一个服务应用，狭义的看，可以看做是IDEA中的一个个 Moudel

###### 微服务架构

(模块化)

是一种架构模式,一种架构风格.核心就是将传统的一站式应用，根据业务拆分成一个一个的服务，彻底地去耦合，每一个微服务提供单个业务功能的服务，一个服务做一件事情，从技术角度看就是一种小而独立的处理过程，类似进程的概念，能够自行单独启动或销毁，拥有自己独立的数据库。



###### 微服务的优缺点

**优点**
1.单一职责原则
2.每个服务足够内聚，足够小，代码容易理解，这样能聚焦一个指定的业务功能或业务需求
3.开发简单，开发效率提高，一个服务可能就是专一的只干一件事
4.微服务能够被小团队单独开发，这个小团队是2-5人的开发人员组成；
5.微服务是松耦合的，是有功能意义的服务，无论是在开发阶段或部署阶段都是独立的
6.微服务能使用不同的语言开发。
7.易于和第三方集成，微服务允许容易且灵活的方式集成自动部署，通过持续集成工具，如 jenkins， Hudson，
bamboo
8.微服务易于被一个开发人员理解，修改和维护，这样小团队能够更关注自己的工作成果。无需通过合作才能体
现价值。
9.微服务允许你利用融合最新技术。
10.微服务只是业务逻辑的代码，不会和HTML，CSS或其他界面混合
11.每个微服务都有自己的存储能力，可以有自己的数据库，也可以有统一数据库



**缺点**
1.开发人员要处理分布式系统的复杂性
2.多服务运维难度，随着服务的增加，运维的压力也在增大
3.系统部署依赖
4.服务间通信成本
5.数据一致性
6.系统集成测试
7.性能监控

###### 微服务技术栈

| 微服务条目                               | 落地技术                                                     |
| ---------------------------------------- | ------------------------------------------------------------ |
| 服务开发                                 | SpringBoot， Spring， SpringMVC                              |
| 服务配置与管理                           | Netflix公司的 Archaius、阿里的 Diamond等                     |
| 服务注册与发现                           | Eureka、 Consul、 Zookeeper等                                |
| 服务调用                                 | Rest、RPC、gRPC                                              |
| 服务熔断器                               | Hystrix、Envoy                                               |
| 负载均衡                                 | Ribbon、 Nginx等                                             |
| 服务接口调用(客户端调用服务的简化工工具) | Feign                                                        |
| 消息队列                                 | Kafka、 RabbitMQ、 ActiveMQ等                                |
| 服务配置中心管理                         | Spring Cloud Config,Chef                                     |
| 服务路由（API网关）                      | Zuul等                                                       |
| 服务监控                                 | Zabbix、 Nagios、 Metrics、 Spectator等                      |
| 全链路追踪                               | Zipkin、 Brave、 Dapper等                                    |
| 服务部署                                 | Docker、 OpenStack、 Kubernetes等                            |
| 数据流操作开发包                         | Spring Cloud Stream（封装 Redis，RabbitMQ， Kafka等发送接收消息 |
| 事件消息总线                             | SpringCloud Bus                                              |



![image-20200106202708662](assets/image-20200106202708662.png)



###### Spring Cloud概述

Spring Cloud利用 Spring Boot的开发便利性，巧妙地简化了分布式系统基础设施的开发， SpringCloud为开发人员提供了快速构建分布式系统的一些工具，包括配置管理，服务发现，断路器，路由，微代理，事件总线，全局锁，决策竟选，分布式会话等等，他们都可以用 SpringBoot的开发风格做到一键启动和部署。

Spring Cloud是分布式微服务架构下的一站式解决方案，是整个微服务架构落地技术的集合体

###### SpringCloud和 SpringBoot关系

Spring Boot专注于快速方便的开发单个个体微服务。
Spring Cloud是关注全局的微服务协调整理治理框架，它将 SpringBoot开发的一个个单体微服务整合并管理起
来，为各个微服务之间提供：配置管理，服务发现，断路器，路由，微代理，事件总线，全局锁，决策竞选，
分布式会话等等集成服务。
SpringBoot可以离开 Spring cloud独立使用，开发项目，但是 Spring cloud离不开 SpringBoot
SpringBoot专注于快速、方便的开发单个个体微服务， SpringCloud关注全局的服务治理



###### Dubbo和SpringCloud的对比

Dubbo停更了5年后重启

|              | Dubbo         | SpringCloud                  |
| ------------ | ------------- | ---------------------------- |
| 服务注册中心 | Zookeeper     | Spring Cloud Netflix Eureka  |
| 服务调用方式 | RPC           | REST API                     |
| 服务监控     | Dubbo-monitor | Spring Boot Admin            |
| 断路器       | 不完善        | Spring Cloud Netflix Hystrix |
| 服务网关     | 无            | Spring Cloud Netflix Zuul    |
| 分布式配置   | 无            | Spring Cloud Config          |
| 服务跟踪     | 无            | Spring Cloud Sleuth          |
| 消息总线     | 无            | Spring Cloud Bus             |
| 数据流       | 无            | Spring Cloud Stream          |
| 批量任务     | 无            | Spring Cloud Task            |

**最大区别：SpringCloud抛弃了Dubbo的RPC通信，采用的是基于HTTP的REST方式**

**解决的问题领域不一样：Dubbo的定位是一款RPC框架， Spring Cloud的目标是微服务架构下的一站式解决方案**

Spring Cloud的版本号是通过伦敦地铁站的名称,按照字母表的顺序来命名的



###### 版本对照

 https://start.spring.io/actuator/info 



# 父工程

先创建一个普通的maven的父项目,父项目的pom文件里面集中管理依赖

![image-20200315161028619](assets/image-20200315161028619.png)

完成后删除 src 目录

```xml
    <!--打包方式 pom-->
    <packaging>pom</packaging>

    <properties>
        <java.version>1.8</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.complier.source>1.8</maven.complier.source>
        <maven.complier.target>1.8</maven.complier.target>
    </properties>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.11.RELEASE</version>
        <relativePath />
    </parent>
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>2.1.11.RELEASE</version>
            </dependency>
            <!--springcloud依赖-->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Greenwich.SR4</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <!--mysql驱动-->
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>8.0.18</version>
                <scope>runtime</scope>
            </dependency>
            <!--druid数据源-->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid</artifactId>
                <version>1.1.21</version>
            </dependency>
            <!--mybatis整合springboot-->
            <dependency>
                <groupId>org.mybatis.spring.boot</groupId>
                <artifactId>mybatis-spring-boot-starter</artifactId>
                <version>2.1.1</version>
            </dependency>
            <!--lombok插件-->
            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>1.18.10</version>
            </dependency>
            <!--测试-->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-test</artifactId>
                <version>2.1.11.RELEASE</version>
                <scope>test</scope>
                <exclusions>
                    <exclusion>
                        <groupId>org.junit.vintage</groupId>
                        <artifactId>junit-vintage-engine</artifactId>
                    </exclusion>
                </exclusions>
            </dependency>
        </dependencies>
    </dependencyManagement>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
```

# springcloud-api

只需提供实体类

在父工程中添加 module(普通 maven 项目):springcloud-api

pom.xml

```xml
    <!--当前module自己需要的依赖,如果父依赖中已经配置了版本,这里就不用写了-->
    <dependencies>
        <!--lombok插件-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <!--热部署-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
    </dependencies>
```

com.yese.pojo.Dept.java

**分布式的实体类必须序列化**

```java
package com.yese.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {

    private static final long serialVersionUID = -5321270206635013415L;
    //自增
    private Integer id;
    private String name;
    //当前数据存在哪个数据库中,通过函数自动生成,微服务,一个服务对应一个数据库
    private String db;

    //这个有参构造由于 id 和 db 都是自动生成的,因此只要一个 name 就够了
    public Dept(String name) {
        this.name = name;
    }
}
```

# springcloud-provider-dept-8001

pom.xml

```xml
    <dependencies>
        <!--web依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--需要用到实体类,配置api model-->
        <dependency>
            <artifactId>springcloud-api</artifactId>
            <groupId>com.yese</groupId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!--mysql驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
        </dependency>
        <!--热部署-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
        <!--测试-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
    </dependencies>
```

application.yml

```yaml
server:
  port: 8001

mybatis:
  #配置别名,pojo的包名
  type-aliases-package: com.yese.pojo
  #mapper.xml文件的路径
  mapper-locations: classpath:mybatis/mapper/*.xml
  #mybatis核心配置文件
  config-location: classpath:mybatis/mybatis-config.xml

spring:
  application:
    #应用的名称,在eureka中可以查看,服务提供者集群的时候保持服务名称一致
    name: springcloud-provider-dept
    #数据库相关
  datasource:
    #url和driverclassname是8.0以上版本的写法,新增最后的时区
    url: jdbc:mysql://47.100.230.188:3306/db01?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password: 123456
    #修改数据库连接池为druid
    type: com.alibaba.druid.pool.DruidDataSource
```

mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <settings>
        <!--显示的开启缓存(默认就是开启的)-->
        <setting name="cacheEnabled" value="true"/>
    </settings>
</configuration>
```

mapper

```java
package com.yese.mapper;

import com.yese.pojo.Dept;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptMapper {

    Dept getDeptById(@Param("id") Integer id);

    List<Dept> getDepts();

    int insertDept(Dept dept);

    int deleteDept(@Param("id") Integer id);

    int updateDept(Dept dept);

}
```

DeptMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.yese.mapper.DeptMapper">

    <select id="getDeptById" resultType="dept">
        select * from dept where id=#{id};
    </select>
    
    <select id="getDepts" resultType="dept">
        select * from dept;
    </select>

    <insert id="insertDept" parameterType="dept">
        insert into dept (name, db) values (#{name},DATABASE());
    </insert>

    <delete id="deleteDept">
        delete from dept where id=#{id};
    </delete>

    <update id="updateDept">
        update dept set name = #{name} where id=#{id};
    </update>

</mapper>
```

service

```java
package com.yese.service;

import com.yese.pojo.Dept;

import java.util.List;

public interface DeptService {
    
    Dept getDeptById(Integer id);

    List<Dept> getDepts();

    int insertDept(Dept dept);

    int deleteDept(Integer id);

    int updateDept(Dept dept);
    
}
```

serviceimpl

```java
package com.yese.service.impl;

import com.yese.mapper.DeptMapper;
import com.yese.pojo.Dept;
import com.yese.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Dept getDeptById(Integer id) {
        return deptMapper.getDeptById(id);
    }

    @Override
    public List<Dept> getDepts() {
        return deptMapper.getDepts();
    }

    @Override
    public int insertDept(Dept dept) {
        return deptMapper.insertDept(dept);
    }

    @Override
    public int deleteDept(Integer id) {
        return deptMapper.deleteDept(id);
    }

    @Override
    public int updateDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }
}

```

controller

```java
package com.yese.controller;

import com.yese.pojo.Dept;
import com.yese.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供restful服务
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/{id}")
    public Dept getDeptById(@PathVariable("id") Integer id) {
        return deptService.getDeptById(id);
    }

    @GetMapping("/dept")
    public List<Dept> getDepts() {
        return deptService.getDepts();
    }

    @PostMapping("/dept")
    public int insertDept(@RequestBody Dept dept) {
        return deptService.insertDept(dept);
    }

    @DeleteMapping("/dept/{id}")
    public int deleteDept(@PathVariable("id") Integer id) {
        return deptService.deleteDept(id);
    }

    @PutMapping("/dept")
    public int updateDept(@RequestBody Dept dept) {
        return deptService.updateDept(dept);
    }
}

```

启动类

```java
package com.yese;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yese.mapper")//扫描mapper接口
public class Provider_Dept_8001_Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider_Dept_8001_Application.class, args);
    }
}
```

启动这个模块

**测试restful api是否ok**

# springcloud-consumer-dept-8080

pom.xml

```xml
    <dependencies>
        <!--需要用到实体类-->
        <dependency>
            <artifactId>springcloud-api</artifactId>
            <groupId>com.yese</groupId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!--web依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--热部署-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
    </dependencies>
```

application.yml

```yaml
server:
  port: 8080
```

config

```java
package com.yese.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration//相当于原来的applicationContext.xml,在这个类里面配bean
public class ConfigBean {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}

```

controller

```java
package com.yese.controller;

import com.yese.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {
    // 理解:消费者不应该有service层
    // RestTemplate,根据提供者的请求类型restTemplate.xxxForObject(url,参数,返回值类型.class);

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    // RestTemplate提供多种便捷访问远程 http 服务的方法,简单的 restful 服务模板
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/dept/{id}")
    public Dept getDeptById(@PathVariable("id") Integer id) {
        //restTemplate.getForEntity()
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/" + id, Dept.class);
    }

    @GetMapping("/consumer/dept")
    public List<Dept> getDepts() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept", List.class);
    }

    @PostMapping("/consumer/dept")
    public int insertDept(@RequestBody Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept", dept, Integer.class);
    }

    @DeleteMapping("/consumer/dept/{id}")
    public void deleteDept(@PathVariable("id") Integer id) {
        restTemplate.delete(REST_URL_PREFIX + "/dept/" + id);
    }

    @PutMapping("/consumer/dept")
    public void updateDept(@RequestBody Dept dept) {
        restTemplate.put(REST_URL_PREFIX + "/dept", dept, Integer.class);
    }
}

```

启动 8001 和 8080

**测试能否调用成功**



# Eureka服务注册与发现

Netflix在设计 Eureka时，遵循的就是AP原则

Eureka是Netflix的—个子模块，也是核心模块之一. Eureka是一个基于REST的服务，用于定位服务，以实现云端中间层服务发现和故障转移，服务注册与发现对于微服务来说是非常重要的，有了服务发现与注册，只需要使用服务的标识符，就可以访问到服务，而不需要修改服务调用的配置文件了，功能类似于 Dubbo的注册中心，比如 Zookeeper

Eureka采用了C-S的架构设计， EurekaServer作为服务注册功能的服务器，他是服务注册中心

而系统中的其他微服务。使用 Eureka的客户端连接到 EurekaServer并维持**心跳连接**。这样系统的维护人员就可以通过 EurekaServer来监控系统中各个微服务是否正常运行， Spring Cloud的一些其他模块（比如Zuul）就可以通过 EurekaServer来发现系统中的其他微服务，并执行相关的逻辑



###### 三大角色

- Eureka Server：提供服务的注册与发现。对比zookeeper

- Service Provider：将自身服务注册到 Eureka中，从而使消费者能够找到。

- Service Consumer：服务消费者从 Eureka中获取注册服务列表，从而找到服务。



###### 自我保护机制：好死不如赖活

一句话总结：某时刻某一个微服务不可以用了， eureka不会立刻清理，依旧会对该微服务的信息进行保存！

默认情况下，如果 EurekaServer在一定时间内没有接收到某个微服务实例的心跳， EurekaServer将会注销该实例（默认90秒）.但是当网络分区故障发生时，微服务与Eureka之间无法正常通行，以上行为可能变得非常危险了,因为微服务本身其实是健康的，此时本不应该注销这个服务。 Eureka通过自我保护机制来解决这个问题.当 EurekaServer节点在短时间内丢失过多客户端时（可能发生了网络分区故障），那么这个节点就会进入自我保护模式。一旦进入该模式， EurekaServer就会保护服务注册表中的信息，不再删除服务注册表中的数据（也就是不会注销任何微服务）,当网络故障恢复后，该 EurekaServer节点会自动退岀自我保护模式

在自我保护模式中，EurekaServer会保护服务注册表中的信息，不再注销任何服务实例。当它收到的心跳数重新恢复到阈值以上时，该EurekaServer节点就会自动退岀自我保护模式。它的设计哲学就是宁可保留错误的服务注册信息，也不盲目注销仼何可能健康的服务实例。

自我保护模式是一种应对网络异常的安全保护措施。它的架构哲学是宁可同时保留所有微服务（健康的微服务和不健康的微服务都会保留），也不盲目注销仼何健康的微服务。使用自我保护模式，可以让 Eureka集群更加的健壮和稳定

在 Spring Cloud中，可以使用 eureka.server.enable-self-preservation = false禁用自我保护模式
【不推荐关闭自我保护机制】

###### 对比 Zookeeper

**回顾CAP原则**

RDBMS（ Mysql、 Oracle、 sqlServer）==>ACID
NoSQL （redis， mongdb）===> CAP

**ACID是什么？**

- A（ Atomicity）原子性

- C（ Consistency）一致性

- I（ Isolation）隔离性

- D（ Durability）持久性

**CAP是什么？**

- C（ Consistency）强一致性

- A（ Availability）可用性

- P（ Partition tolerance）分区容错性

CAP的三进二(只能三选二)：CA、AP、CP

**CAP理论的核心**

一个分布式系统不可能同时很好的满足一致性，可用性和分区容错性这三个需求
根据CAP原理，将NoSQL数据库分成了满足CA原则，满足CP原则和满足AP原则三大类:

- CA：单点集群，满足一致性，可用性的系统，通常可扩展性较差

- CP：满足一致性，分区容错性的系统，通常性能不是特别高

- AP：满足可用性，分区容错性的系统，通常可能对一致性要求低一些

**作为服务注册中心， Eureka比 Zookeeper好在哪里？**

著名的CAP理论指岀，一个分布式系统不可能同时满足C（一致性）、A（可用性）、P（容错性）
由于分区容错性P在分布式系统中是必须要保证的，因此我们只能在A和C之间进行权衡。
Zookeeper保证的是CP；
Eureka保证的是AP；



**Zookeeper保证的是CP**

当向注册中心查询服务列表时，我们可以容忍注册中心返回的是几分钟以前的注册信息，但不能接受服务直接down掉不可用。也就是说，服务注册功能对可用性的要求要高于一致性。但是zk会岀现这样一种情况，当 master节点因为网络故障与其他节点失去联系时，剩余节点会重新进行 leader选举。问题在于，选举 leader的时间太长，30-120s，且选举期间整个zk集群都是不可用的，这就导致在选举期间注册服务瘫痪。在云部署的环境下，因为网络问题使得zk集群失去 master节点是较大概率会发生的事件，虽然服务最终能够恢复，但是漫长的选举时间导致的注册长期不可用是不能容忍的。

**Eureka保证的是AP**
Eureka看明白了这一点，因此在设计时就优先保证可用性。 Eureka各个节点都是平等的，几个节点挂掉不会影响正常节点的工作，剩余的节点依然可以提供注册和查询服务。而 Eureka的客户端在向某个 Eureka注册时，如果发现连接失败，则会自动切换至其他节点，只要有一台 Eureka还在，就能保住注册服务的可用性，只不过査到的信息可能不是最新的，除此之外， Eureka还有一种自我保护机制，如果在15分钟内超过85%的节点都没有正常的心跳，那么 Eureka就认为客户端与注册中心出现了网络故障，此时会出现以下几种情况

1.Eureka不再从注册列表中移除因为长时间没收到心跳而应该过期的服务

2.Eureka仍然能够接受新服务的注册和査询请求，但是不会被同步到其他节点上（即保证当前节点依然可用）

3.当网络稳定时，当前实例新的注册信息会被同步到其他节点中



**结论: Eureka可以很好的应对因网络故障导致部分节点失去联系的情况，而不会像 zookeeper那样使整个注册服务瘫痪**

补充:

```yaml
    #显示服务的ip地址
    prefer-ip-address: true
```



# springcloud-eureka-7001

```xml
    <dependencies>
        <!--eureka注册中心-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka-server</artifactId>
            <version>1.4.7.RELEASE</version>
        </dependency>
        <!--热部署-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
    </dependencies>
```

application.yml

```yaml
server:
  port: 7001

#Eureka配置
eureka:
  instance:
    #Eureka服务端的实例名称
    hostname: localhost
  client:
    #表示是否向Eureka服务中心注册自己
    register-with-eureka: false
    #false表示自己为注册中心
    fetch-registry: false
    service-url:
      #注册的地址
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```

启动类

```java
package com.yese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer//EurekaServer服务端
public class Eureka_Server_7001_Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka_Server_7001_Application.class, args);
    }
}

```

启动该模块,访问: http://localhost:7001/ 

![image-20200111153416735](assets/image-20200111153416735.png)



**下一步:将服务提供者注册进Eureka**



8001项目的pom.xml添加

```xml
        <!--eureka服务提供者-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka</artifactId>
            <version>1.4.7.RELEASE</version>
        </dependency>
```

application.yml添加

```yaml
#配置eureka,服务注册到哪里
eureka:
  client:
    service-url:
      #单机版:
      defaultZone: http://localhost:7001/eureka/
  instance:
    #修改Status,描述
    instance-id: springcloud-provider-dept-8001
```

先启动7001,再启动8001,访问http://localhost:7001/ 

![image-20200111154410938](assets/image-20200111154410938.png)

配置status上面的链接

8001的pom添加

```xml
        <!--完善监控信息-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
            <version>2.2.2.RELEASE</version>
        </dependency>
```

application.yml添加

```yaml
#actuator包的具体配置,即点Status的链接进去的具体信息
info:
  app.name: springcloud-demo
  company.name: com.yese
```

点击Status的链接

![image-20200111155116900](assets/image-20200111155116900.png)



discovery配置

(多用于团队开发)

8001的controller中添加

```java
    //------------------以下为团队开发中可能会用得到的,并不影响正常使用,获取一些服务的具体信息
    @Autowired
    // 注意导springcloud的包
    private DiscoveryClient client;

    @GetMapping("/dept/discovery")
    public Object discovery() {
        //获取服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery--->services" + services);

        //得到一个具体的微服务信息,通过具体的微服务id, applicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "---" +
                            instance.getPort() + "---" +
                            instance.getUri() + "---" +
                            instance.getServiceId()
            );
        }
        return this.client;
    }
```

主启动类加

```java
@EnableDiscoveryClient//Discovery团队开发获取服务的具体信息
```

访问 http://localhost:8001/dept/discovery 

![image-20200111155742199](assets/image-20200111155742199.png)

至此单机环境搭建完成,接下来搭建集群环境!

先仿照7001创建7002和7003两个模块,分别修改端口号和主启动类

接下来进行集群配置

为了模拟正式环境,先修改C:\Windows\System32\drivers\etc\hosts文件

mac:打开Finder,快捷键组合 Shift+Command+G ，并输入 Hosts 文件的所在路径：/etc/hosts

复制这个「hosts」文件到桌面上，修改内容。将修改好的 hosts 文件替换原始的 hosts 文件就好了

添加:

```
127.0.0.1       eureka7001.com
127.0.0.1       eureka7002.com
127.0.0.1       eureka7003.com
```

再分别修改3个eureka注册中心的application.yml

7001

```yaml
server:
  port: 7001

#Eureka配置
eureka:
  instance:
    #Eureka服务端的实例名称
    hostname: eureka7001.com
  client:
    #表示是否向Eureka服务中心注册自己
    register-with-eureka: false
    #false表示自己为注册中心
    fetch-registry: false
    service-url:
      #注册的地址
      #单机的写法:defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
      #集群(关联)
      defaultZone: http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
```

7002

```yaml
server:
  port: 7002

#Eureka配置
eureka:
  instance:
    #Eureka服务端的实例名称
    hostname: eureka7002.com
  client:
    #表示是否向Eureka服务中心注册自己
    register-with-eureka: false
    #false表示自己为注册中心
    fetch-registry: false
    service-url:
      #注册的地址
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7003.com:7003/eureka/

```

7003

```yaml
server:
  port: 7003

#Eureka配置
eureka:
  instance:
    #Eureka服务端的实例名称
    hostname: eureka7003.com
  client:
    #表示是否向Eureka服务中心注册自己
    register-with-eureka: false
    #false表示自己为注册中心
    fetch-registry: false
    service-url:
      #注册的地址
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/
```

接下来修改 8001,将服务提供者注册到集群中去

```yaml
#配置eureka,服务注册到哪里
eureka:
  client:
    service-url:
      #单机版:defaultZone: http://localhost:7001/eureka/
      #集群版
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
  instance:
    #修改Status,描述
    instance-id: springcloud-provider-dept-8001
```

分别启动7001,7002,7003,8001,8080

测试8080的api能不能正常访问



# Ribbon负载均衡

**ribbon是什么？**
Spring Cloud Ribbon是基于 Netflix Ribbon实现的一套**客户端负载均衡的工具**。
简单的说， Ribbon是Netflix发布的开源项目，主要功能是提供客户端的软件负载均衡算法，将 Netflix的中间层服务连接在一起。 Ribbon的客户端组件提供一系列完整的配置项,如：连接超时、重试等等。简单的说，就是在配置文件中列岀 LoadBalance（简称LB：负载均衡）后面所有的机器， Ribbon会自动的帮助你基于某种规则（如简单轮询，随机连接等等）去连接这些机器。我们也很容易使用 Ribbon实现自定乂的负载均衡算法

**ribbon能干嘛**
LB，即负载均衡（ LoadBalance），在微服务或分布式集群中经常用的一种应用
负载均衡简单的说就是将用户的请求平摊的分配到多个服务上，从而达到系统的HA（高可用）
常见的负载均衡软件有 Nginx，Lvs等等
dubbo、 SpringCloud中均给我们提供了负载均衡， Spring Cloud的负载均衡算法可以自定义

**负载均衡简单分类**
1.集中式LB
即在服务的消费方和提供方之间使用独立的LB设施，如 Nginx，由该设施负责把访问请求通过某种策略转发至服务的提供方！

2.进程式LB
将LB逻辑集成到消费方，消费方从服务注册中心获知有哪些地址可用，然后自己再从这些地址中选出一个合适的服务器。
Ribbon就属于进程式LB，它只是一个类库，集成于消费方进程，消费方通过它来获取到服务提供方的地址！



## 整合Ribbon

springcloud-consumer-dept-8080

```xml
        <!--ribbon-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-ribbon</artifactId>
            <version>1.4.7.RELEASE</version>
        </dependency>
        <!--eureka-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka</artifactId>
            <version>1.4.7.RELEASE</version>
        </dependency>
```

yml添加

```yaml
#Eureka配置
eureka:
  client:
    #表示不向Eureka服务中心注册自己
    register-with-eureka: false
    service-url:
      #集群
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
```

修改config

```java
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

```

修改controller

```java
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    //配置了ribbon之后,访问的地址应该是一个变量,通过服务名来访问
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

```

主启动类添加

```java
@EnableEurekaClient//ribbon和eureka整合以后,客户端可以直接调用,不用关心ip地址和端口号
```



创建服务提供者的集群

仿照8001创建8002和8003两个模块,分别修改端口号,数据库,Status描述,主启动类

**测试**

依次启动700x,800x,8080

多次请求 http://localhost:8080/consumer/dept/ ,发现db字段在有规律的变化(轮询)

至此Ribbon整合完成

# Feign负载均衡

feign是声明式的 web service客户端，它让微服务之间的调用变得更简单了，类似 controller调用 service。
只需要创建一个接口，然后添加注解，完成对服务提供方的接口绑定，简化了 Spring Cloud Ribbon

**调用微服务访问的两种方法**
1.微服务名字【ribbon】
2.接口和注解【feign】

feign集成了ribbon

# springcloud-consumer-dept-feign-8080

仿照springcloud-consumer-dept-8080创建使用Feign做负载均衡的模块

修改主配置类名称Consumer_Dept_Feign_8080_application

pom新增

```xml
        <!--feign-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-feign</artifactId>
            <version>1.4.7.RELEASE</version>
        </dependency>
```

springcloud-api中新建一个service,同时也添加上述依赖

```java
package com.yese.service;

import com.yese.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 使用feign代替ribbon来完成负载均衡,如果不使用 feign 不用写
 */
//value是服务的名称,原来是在消费者的controller里写死的
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
@Component
public interface FeignDeptClientService {

    @GetMapping("/dept/{id}")
    Dept getDeptById(@PathVariable("id") Integer id);

    @GetMapping("/dept")
    List<Dept> getDepts();

    @PostMapping("/dept")
    int insertDept(@RequestBody Dept dept);

    @DeleteMapping("/dept/{id}")
    int deleteDept(@PathVariable("id") Integer id);

    @PutMapping("/dept")
    int updateDept(@RequestBody Dept dept);

}

```

springcloud-consumer-dept-feign-8080

修改controller

```java
package com.yese.controller;

import com.yese.pojo.Dept;
import com.yese.service.FeignDeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    // 注入springcloud-api中的 service 接口
    @Autowired
    private FeignDeptClientService feignDeptClientService;

    @GetMapping("/consumer/dept/{id}")
    public Dept getDeptById(@PathVariable("id") Integer id) {
        return feignDeptClientService.getDeptById(id);
    }

    @GetMapping("/consumer/dept")
    public List<Dept> getDepts() {
        return feignDeptClientService.getDepts();
    }

    @PostMapping("/consumer/dept")
    public int insertDept(@RequestBody Dept dept) {
        return feignDeptClientService.insertDept(dept);
    }

    @DeleteMapping("/consumer/dept/{id}")
    public void deleteDept(@PathVariable("id") Integer id) {
        feignDeptClientService.deleteDept(id);
    }

    @PutMapping("/consumer/dept")
    public void updateDept(@RequestBody Dept dept) {
        feignDeptClientService.updateDept(dept);
    }
}

```

主启动类增加

```java
@EnableFeignClients(basePackages = {"com.yese"})
```

启动测试,效果和之前使用ribbon是一样的,至此使用feign代替ribbon负载均衡完成

# Hystrix服务熔断

**是在服务端的处理**

**弃车保帅**

Hystrix是一个用于处理分布式系统延迟和容错的开源库，在分布式系统里，许多依赖不可避免的会调用失败，比如超时，异常等， Hystrix能够保证在一个依赖岀问题的情况下，不会导致整体服务失败，避免级联故障，以提高分布式系统的弹性

断路器本身是一种开关装置，当某个服务单元发生故障之后，通过断路器的故障监控（类似熔断保险丝），向调用方返回一个服务预期的，可处理的备选响应（ FallBack），而不是长时间的等待或者抛出调用方法无法处理的异常，这样就可以保证了服务调用方的线程不会被长时间，不必要的占用，从而避免了故障在分布式系统中的蔓延，乃至雪崩

###### Hystrix作用

服务降级
服务熔断
服务限流
接近实时的监控

###### 服务熔断

熔断机制是对应雪崩效应的一种微服务链路保护机制。

当扇出链路的某个微服务不可用或者响应时间太长时，会进行服务的降级，进而**熔断该节点微服务的调用，快速返回错误的响应信息**。当检测到该节点微服务调用响应正常后恢复调用链路。在 Springcloud框架里熔断机制通过 Hystrix实现。 Hystrix会监控微服务间调用的状况，当失败的调用到一定阈值，缺省是5秒内20次调用失败就会启动熔断机制。熔断机制的注解是**@HystrixCommand**

## springcloud-provider-dept-hystrix-8001

仿照8001创建基于hystrix的8001,修改status描述和主启动类

```yml
  instance:
    #修改Status,描述
    instance-id: springcloud-provider-dept-hystrix-8001
```

```java
public class Provider_Dept_Hystrix_8001_Application {}
```



pom新增

```xml
        <!--hystrix-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-hystrix</artifactId>
            <version>1.4.7.RELEASE</version>
        </dependency>
```

修改controller

```java
package com.yese.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yese.pojo.Dept;
import com.yese.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//提供restful服务
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGetDeptById")//该方法调用失败就执行hystrixGetDeptById这个方法
    public Dept getDeptById(@PathVariable("id") Integer id) {
        Dept dept = deptService.getDeptById(id);
        //模拟出错
        if (dept == null) {
            throw new RuntimeException("id为:" + id + "的员工不存在");
        }
        return dept;
    }

    //备选方法
    public Dept hystrixGetDeptById(@PathVariable("id") Integer id) {
        return new Dept()
                .setId(id)
                .setName("id为:" + id + "的员工不存在")
                .setDb("");
    }

}

```

主启动类添加

```java
@EnableCircuitBreaker//添加对熔断的支持(断路器)
```

启动 700x,springcloud-provider-dept-hystrix-8001,springcloud-consumer-dept-feign-8080

访问 http://localhost:8080/consumer/dept/1 ,如果是存在的id,效果和之前一样,如果是不存在的id

![image-20200111214456934](assets/image-20200111214456934.png)

至此hystrix服务熔断整合完成

# Hystrix服务降级

**在客户端的处理**

当服务器压力剧增的情况下，根据当前业务情况及流量对一些服务和页面有策略的降级，以此释放服务器资源以保证核心任务的正常运行。比如电商平台，在针对618、双11等高峰情形下采用部分服务不出现或者延时出现的情形。

## springcloud-api

service包下新建

```java
package com.yese.service;

import com.yese.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
// 实现FallbackFactory接口
public class FeignDeptClientServiceFallbackFactory implements FallbackFactory {

    // 重写create方法,返回springcloud-api该服务的 service 接口,重写接口中的方法,这里就演示一个getDeptById
    @Override
    public FeignDeptClientService create(Throwable cause) {
        return new FeignDeptClientService() {
            @Override
            public Dept getDeptById(Integer id) {
                return new Dept()
                        .setId(id)
                        .setName("服务正在升级...请等待")
                        .setDb("");
            }

            @Override
            public List<Dept> getDepts() {
                return null;
            }

            @Override
            public int insertDept(Dept dept) {
                return 0;
            }

            @Override
            public int deleteDept(Integer id) {
                return 0;
            }

            @Override
            public int updateDept(Dept dept) {
                return 0;
            }
        };
    }
}

```

FeignDeptClientService修改

```java
// fallbackFactory是Hystrix服务降级时需要修改的
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT", fallbackFactory = FeignDeptClientServiceFallbackFactory.class)
```

springcloud-consumer-dept-feign-8080的yml修改

```yaml
feign:
  hystrix:
    #开启hystrix服务降级
    enabled: true
```

启动 700x,springcloud-provider-dept-hystrix-8001,springcloud-consumer-dept-feign-8080

启动之后正常访问效果和之前一样.如果突然关闭8001,仍能访问,返回的是预定的信息

![image-20200112002350158](assets/image-20200112002350158.png)

# 对比

服务熔断：服务端,某个服务超时或者异常，避免服务雪崩

服务降级；客户端,从网站整体请求负载考虑，当某个服务熔断或者关闭之后，服务将不再被调用,可以通过FallbackFactory，返回一个默认值（缺省值），相比服务直接挂掉,体验好一些



# dashboard监控

## springcloud-consumer-hystrix-dashboard-9001

pom:参考springcloud-consumer-dept-8080的依赖,再添加

```xml
        <!--hystrix-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-hystrix</artifactId>
            <version>1.4.7.RELEASE</version>
        </dependency>
        <!--dashboard-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
            <version>1.4.7.RELEASE</version>
        </dependency>
```

yml

```yaml
server:
  port: 9001
```

创建主启动类

```java
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

```

访问 http://localhost:9001/hystrix 可以看到一头猪

接下来在服务里面配置,前提是要有spring-boot-starter-actuator依赖

以springcloud-provider-dept-hystrix-8001为例

在主启动类中添加

```java
    //Hystrix监控
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }
```

在http://localhost:9001/hystrix页面添加

![image-20200112010353293](assets/image-20200112010353293.png)

http://localhost:8001/actuator/hystrix.stream

访问8080的请求就会统计监控

![image-20200112010711918](assets/image-20200112010711918.png)



# Zuul路由网关

###### 概述

Zuul包含了对请求的路由和过滤两个最主要的功能
其中路由功能负责将外部请求转发到具体的微服务实例上，是实现外部访问统一入口的基础，而过滤器功能则负责对请求的处理过程进行干预，是实现请求校验，服务聚合等功能的基础。Zuul和Eureka进行整合，**将Zuul自身注册为 Eureka服务治理下的应用**，同时从 Eureka中获得其他微服务的消息，这样,以后的访问微服务都是通过Zuul跳转后获得

注意：Zuul服务最终还是会注册进 Eureka
提供：代理+路由+过滤三大功能！

## springcloud-zuul-9200

pom参考springcloud-consumer-hystrix-dashboard-9001,新增

```xml
        <!--zuul-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zuul</artifactId>
            <version>1.4.7.RELEASE</version>
        </dependency>
```

yml

```yaml
server:
  port: 9200

spring:
  application:
    #服务的名称
    name: springcloud-zuul

#将zuul注册进eureka
eureka:
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
  instance:
    #修改Status,描述
    instance-id: springcloud-zuul-9200


#actuator包的具体配置,即点Status的链接进去的具体信息
info:
  app.name: springcloud-zuul
  company.name: com.yese
```

host文件添加,模拟真实环境

```
127.0.0.1       www.yese.com
```

创建主启动类

```java
package com.yese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableZuulProxy//开启zuul
public class Zuul_9200_Application {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_9200_Application.class, args);
    }
}

```

首先访问:http://www.yese.com:9200/springcloud-provider-dept/dept/1,发现可以访问到数据,但是要通过服务名去访问,会暴露服务名

添加配置文件

```yml
#网关配置
zuul:
  routes:
    mydept.serviceId: SPRINGCLOUD-PROVIDER-DEPT
    #将该服务的访问地址映射
    mydept.path: /mydept/**
  #不能使用原始的带服务名的方式访问
  #ignored-services: SPRINGCLOUD-PROVIDER-DEPT
  #如果服务很多,可以全部影藏
  ignored-services: "*"
  #添加统一的前缀(可以不设置)
  prefix: /nt

```



访问 http://www.yese.com:9200/nt/mydept/dept/1 

# config分布式配置

![d0936fae5dcfcb1bb8d595f769be2779](assets/d0936fae5dcfcb1bb8d595f769be2779.png)

###### 概述

分布式系统面临的配置文件的问题：
微服务意味着要将单体应用中的业务拆分成一个个子服务，每个服务的粒度相对较小，因此系统中会岀现大量的服务，由于每个服务都需要必要的配置信息才能运行，所以一套集中式的，动态的配置管理设施是必不可少的。SpringCloud提供了 ConfigServer来解决这个问题

Spring Cloud Config为微服务架构中的微服务提供集中化的外部配置支持，配置服务器为各个不同微服务应用的所有环节提供了一个中心化的外部配置。
Spring Cloud Config分为服务端和客户端两部分
服务端也称为分布式配置中心，它是一个独立的微服务应用，用来连接配置服务器并为客户端提供获取配置信息，加密，解密信息等访问接口。
客户端则是通过指定的配置中心来管理应用资源，以及与业务相关的配置内容，并在启动的时候从配置中心获取和加载配置信息。配置服务器默认采用git来存储配置信息，这样就有助于对环境配置进行版本管理。并且可以通过git客户端工具来方便的管理和访问配置内容。

###### 作用

集中管理配置文件
不同环境，不同配置，动态化的配置更新，分环境部署
运行期间动态调整配置，不再需要在每个服务部署的机器上编写置文件，服务会向配置中心统一拉取配置自己的信息。
当配置发生变动时，服务不需要重启，即可感知到配置的变化，并应用新的配置
将配置信息以REST接口的形式暴露

## 服务端

作用:通过config-server可以连接到远程的 git 仓库,访问远端的配置文件

### springcloud-config-server-3344

远程的application.yml

```yaml
spring:
  profiles:
    #激活dev环境
    active: dev

---
spring:
  profiles: dev
  application:
    name: springcloud-config-dev
    
---
spring:
  profiles: test
  application:
    name: springcloud-config-test
```

pom

```xml
    <dependencies>
        <!--config-server-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
            <version>2.1.5.RELEASE</version>
        </dependency>
        <!--web依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
```

application.yml

```yml
server:
  port: 3344

spring:
  application:
    #服务的名称
    name: springcloud-config-server
  cloud:
    config:
      server:
        git:
          #连接git远程仓库(https的链接),可以访问远程的配置
          uri: https://github.com/yese777/springcloud-config-server.git
          
```

主启动类

```java
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

```

启动后

Spring Cloud Config 有它的一套访问规则，我们通过这套规则在浏览器上直接访问就可以。

```
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
```

{application} 就是应用名称，对应到配置文件上来，就是配置文件的名称部分。

{profile} 就是配置文件的版本，有开发版本、测试环境版本、生产环境版本...

{label} 表示 git 分支，默认是 master 分支

访问 http://localhost:3344/application-test.yml 可以拿到配置信息

## 客户端

### springcloud-config-client-3355

此模块的端口从远程获取,这里随便命名的

远程的config-client.yml

```yaml
spring:
  profiles:
    #激活dev环境
    active: dev

---
server:
  port: 8201
spring:
  profiles: dev
  application:
    name: springcloud-provider-dept

eureka:
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
      
---
server:
  port: 8202
spring:
  profiles: test
  application:
    name: springcloud-provider-dept

eureka:
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
```

pom

```xml
    <dependencies>
        <!-- spring cloud config 客户端包 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
    </dependencies>
```

application.yml

```yaml
#application.yml用户级别的配置
spring:
  application:
    name: springcloud-config-client
```

bootstrap.yml

```yaml
#bootstrap.yml系统级别的配置
spring:
  cloud:
    config:
      #之前在浏览器中直接能访问到配置文件的地址:http://localhost:3344/config-client-dev.yml
      #config的服务端地址,就是刚刚创建的springcloud-config-server-3344的地址
      uri: http://localhost:3344
      #需要从git上读取的配置文件的名称,不需要后缀
      name: config-client
      #获取上述文件中的dev的环境
      profile: dev
      #分支
      label: master

```

controller

```java
package com.yese.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过该控制器,查看获取到的远端的配置文件的内容
 */
@RestController
public class ConfigClientController {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig() {
        return "applicationName:" + applicationName +
                "eurekaServer:" + eurekaServer +
                "port:" + port;
    }

}

```



启动类

```java
@SpringBootApplication
public class Config_Client_3355_Application {
    public static void main(String[] args) {
        SpringApplication.run(Config_Client_3355_Application.class, args);
    }
}

```

客户端启动后发现端口是8201

访问 http://localhost:8201/config 页面上展示:

 applicationName:springcloud-provider-depteurekaServer:http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/port:8201 

说明客户端连接上了服务端,而服务端又连接上了远端git,所以能拿到远程的配置文件

如果将bootstrap.yml中的profile改为 test,重启项目后发现端口改为了 8202

实现了配置与编码解耦

## 案例

将原来7001和8001的配置放在远程

远程的config-eureka.yml(7001的配置)

(照搬原来本地的配置,两个环境只有端口不同)

```yaml
spring:
  profiles:
    #激活dev环境
    active: dev
---
server:
  port: 7001
spring:
  profiles: dev
  application:
    name: springcloud-config-eureka
#Eureka配置
eureka:
  instance:
    #Eureka服务端的实例名称
    hostname: eureka7001.com
  client:
    #表示是否向Eureka服务中心注册自己
    register-with-eureka: false
    #false表示自己为注册中心
    fetch-registry: false
    service-url:
      #注册的地址
      #单机的写法:defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
      #集群(关联)
      defaultZone: http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
      
---
server:
  port: 7011
spring:
  profiles: test
  application:
    name: springcloud-config-eureka
#Eureka配置
eureka:
  instance:
    #Eureka服务端的实例名称
    hostname: eureka7001.com
  client:
    #表示是否向Eureka服务中心注册自己
    register-with-eureka: false
    #false表示自己为注册中心
    fetch-registry: false
    service-url:
      #注册的地址
      #单机的写法:defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
      #集群(关联)
      defaultZone: http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
```



远程的config-dept.yml(8001的配置)

(照搬原来本地的配置,两个环境只有端口不同)

```yaml
spring:
  profiles:
    #激活dev环境
    active: dev
---
server:
  port: 8001

mybatis:
  #配置别名,pojo的包名
  type-aliases-package: com.yese.pojo
  #mapper.xml文件的路径
  mapper-locations: classpath:mybatis/mapper/*.xml
  #mybatis核心配置文件
  config-location: classpath:mybatis/mybatis-config.xml

spring:
  profiles: dev
  application:
    #应用的名称,在eureka中可以查看,服务提供者集群的时候保持服务名称一致
    name: springcloud-provider-dept
    #数据库相关
  datasource:
    #url和driverclassname是8.0以上版本的写法,新增最后的时区
    url: jdbc:mysql://47.100.230.188:3306/db01?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password: 1321810135
    #修改数据库连接池为druid
    type: com.alibaba.druid.pool.DruidDataSource

#配置eureka,服务注册到哪里
eureka:
  client:
    service-url:
      #单机版:defaultZone: http://localhost:7001/eureka/
      #集群版
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
  instance:
    #修改Status,描述
    instance-id: springcloud-provider-dept-8001

#actuator包的具体配置,即点Status的链接进去的具体信息
info:
  app.name: springcloud-demo
  company.name: com.yese
---
server:
  port: 8011

mybatis:
  #配置别名,pojo的包名
  type-aliases-package: com.yese.pojo
  #mapper.xml文件的路径
  mapper-locations: classpath:mybatis/mapper/*.xml
  #mybatis核心配置文件
  config-location: classpath:mybatis/mybatis-config.xml

spring:
  profiles: test
  application:
    #应用的名称,在eureka中可以查看,服务提供者集群的时候保持服务名称一致
    name: springcloud-provider-dept
    #数据库相关
  datasource:
    #url和driverclassname是8.0以上版本的写法,新增最后的时区
    url: jdbc:mysql://47.100.230.188:3306/db01?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password: 1321810135
    #修改数据库连接池为druid
    type: com.alibaba.druid.pool.DruidDataSource

#配置eureka,服务注册到哪里
eureka:
  client:
    service-url:
      #单机版:defaultZone: http://localhost:7001/eureka/
      #集群版
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
  instance:
    #修改Status,描述
    instance-id: springcloud-provider-dept-8001

#actuator包的具体配置,即点Status的链接进去的具体信息
info:
  app.name: springcloud-demo
  company.name: com.yese

```

仿照原来的springcloud-eureka-7001和springcloud-provider-dept-8001再创建两个模块

### springcloud-config-eureka-7001

新增依赖

```xml
        <!-- spring cloud config 客户端包 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
```

application.yml(原来的内容全部删掉)

```yaml
spring:
  application:
    name: springcloud-config-eureka-7001
```

bootstrap.yml

```yaml
#bootstrap.yml系统级别的配置
spring:
  cloud:
    config:
      #之前在浏览器中直接能访问到配置文件的地址:http://localhost:3344/config-eureka-dev.yml
      #config的服务端地址,就是刚刚创建的springcloud-config-server-3344的地址
      uri: http://localhost:3344
      #需要从git上读取的配置文件的名称,不需要后缀
      name: config-eureka
      #获取上述文件中的dev的环境
      profile: dev
      #分支
      label: master

```

主启动类

```java
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

```

启动项目springcloud-config-server-3344和springcloud-config-client-3355和新的 7001

访问 http://localhost:7001/ 和原来的效果一样

如果springcloud-config-eureka-7001的profile改为 test,端口为 7011



### springcloud-config-provider-dept-8001

新增依赖

```xml
        <!-- spring cloud config 客户端包 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
```

application.yml(原来的内容全部删掉)

```yaml
spring:
  application:
    name: springcloud-config-provider-dept-8001
```

bootstrap.yml

```yaml
#bootstrap.yml系统级别的配置
spring:
  cloud:
    config:
      #需要从git上读取的配置文件的名称,不需要后缀
      name: config-dept
      #获取上述文件中的dev的环境
      profile: dev
      #分支
      label: master
      #config的服务端地址
      uri: http://localhost:8101
```

主配置类

```java
package com.yese;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.yese.mapper")//扫描mapper接口
@EnableDiscoveryClient//Discovery团队开发获取服务的具体信息
@EnableEurekaClient//ribbon和eureka整合以后,客户端可以直接调用,不用关心ip地址和端口号
public class Config_Provider_Dept_8001_Application {

    public static void main(String[] args) {
        SpringApplication.run(Config_Provider_Dept_8001_Application.class, args);
    }

}
```

启动项目springcloud-config-server-3344和springcloud-config-client-3355和springcloud-config-eureka-7001和新的 8001

启动项目,访问  http://localhost:8001/dept  和原来的效果一样

如果springcloud-config-provider-dept-8001的profile改为 test,端口为 8011

整合完成!



后续:后面可以整合springboot bus来实现修改远程 git 上的配置文件,项目实时自动更新









