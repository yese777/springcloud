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
// fallbackFactory是Hystrix服务降级时需要修改的
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT", fallbackFactory = FeignDeptClientServiceFallbackFactory.class)
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
