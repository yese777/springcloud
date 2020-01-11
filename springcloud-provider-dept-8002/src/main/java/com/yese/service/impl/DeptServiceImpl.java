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
