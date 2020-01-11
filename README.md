# SpringCloud整合



# 父工程

先创建一个maven的父项目,父项目的pom文件里面集中管理依赖

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
    </dependencies>
```

com.yese.pojo.Dept.java

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
    private Long id;
    private String name;
    //当前数据存在哪个数据库中,通过函数自动生成
    private String db;

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

properties.yml

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
    url: jdbc:mysql://192.168.236.135:3306/DB01?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
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

**测试restful api是否ok**

# springcloud-consumer-dept-8080

pom.xml

```xml
    <dependencies>
        <!--web依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--需要用到实体类-->
        <dependency>
            <artifactId>springcloud-api</artifactId>
            <groupId>com.yese</groupId>
            <version>1.0-SNAPSHOT</version>
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

**测试能否调用成功**

# Eureka注册中心

## springcloud-eureka-7001

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

先启动8001,再启动7001,访问http://localhost:7001/ 



配置status链接

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



discovery配置

(多用于团队开发)

8001的controller中添加

```java
    //------------------以下为团队开发中可能会用得到的,并不影响正常使用,获取一些服务的具体信息
    @Autowired
    //springcloud的包
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



至此单机环境搭建完成,接下来搭建集群环境!

先仿照7001创建7002和7003两个模块,分别修改端口号和主启动类

接下来进行集群配置

为了模拟正式环境,先修改C:\Windows\System32\drivers\etc\hosts文件

添加

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

接下来将服务提供者注册到集群中去

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

## springcloud-consumer-dept-feign-8080

仿照springcloud-consumer-dept-8080创建使用Feign做负载均衡的模块

pom添加

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
 * 使用feign代替ribbon
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

## springcloud-provider-dept-hystrix-8001

仿照8001创建基于hystrix的8001,修改status描述和主启动类

pom

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

启动后访问 http://localhost:8080/consumer/dept/1 ,如果是存在的id,效果和之前一样,如果是不存在的id



至此hystrix服务熔断整合完成

# Hystrix服务降级

## springcloud-api

service包下新建

```java
package com.yese.service;

import com.yese.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//实现FallbackFactory接口
public class FeignDeptClientServiceFallbackFactory implements FallbackFactory {

    //重写create方法,返回服务接口,重写接口中的方法,这里就演示一个
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
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT", fallbackFactory = FeignDeptClientServiceFallbackFactory.class)
```

springcloud-consumer-dept-feign-8080的yml修改

```yaml
feign:
  hystrix:
    #开启降级
    enabled: true
```

启动之后正常访问效果和之前一样.如果突然关闭8001,仍能访问,返回的是预定的信息

# dashboard监控

## springcloud-consumer-hystrix-dashboard-9001

pom:参考8080的依赖,再添加

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

在http://localhost:9001/hystrix页面添加http://localhost:8001/actuator/hystrix.stream

访问8080的请求就会统计数据

# Zuul路由网关

## springcloud-zuul-9200

pom参考springcloud-consumer-hystrix-dashboard-9001,添加

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

#网关配置
zuul:
  routes:
    mydept.serviceId: SPRINGCLOUD-PROVIDER-DEPT
    #将该服务的访问地址映射
    mydept.path: /mydept/**
  #不能使用以下路径访问
  #ignored-services: SPRINGCLOUD-PROVIDER-DEPT
  #服务很多,全部影藏
  ignored-services: "*"
  #添加统一的前缀(可以不设置)
  prefix: /nt

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



访问 http://www.yese.com:9200/nt/mydept/dept 













