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