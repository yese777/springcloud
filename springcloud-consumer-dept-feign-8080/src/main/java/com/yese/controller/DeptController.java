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
