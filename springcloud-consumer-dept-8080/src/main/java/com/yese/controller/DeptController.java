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

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    //配置了ribbon之后,访问的地址应该是一个变量,通过服务名来访问
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

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
