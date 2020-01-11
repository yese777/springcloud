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
    //当前数据存在哪个数据库中,通过函数自动生成
    private String db;

    public Dept(String name) {
        this.name = name;
    }
}