package com.mywork.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.mywork.mybatisplus.generator.system.mapper"})
@MapperScan("com.mywork.mybatisplus.mapper")// 设置 mapper 目录扫描，mapper 中不加 @Mapper 注解也可以，但最好加上，这是规范
public class MybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusApplication.class, args);
    }

}
