package com.yese.controller;

import com.yese.pojo.Dept;
import com.yese.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
}

