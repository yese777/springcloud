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