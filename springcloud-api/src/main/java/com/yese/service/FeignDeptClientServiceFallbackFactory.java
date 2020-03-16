package com.yese.service;

import com.yese.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
// 实现FallbackFactory接口
public class FeignDeptClientServiceFallbackFactory implements FallbackFactory {

    // 重写create方法,返回springcloud-api该服务的 service 接口,重写接口中的方法,这里就演示一个getDeptById()
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

