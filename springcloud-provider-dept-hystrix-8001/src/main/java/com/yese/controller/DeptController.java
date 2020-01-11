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
