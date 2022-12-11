package com.mywork.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.mywork.mybatisplus.generator.system.mapper","com.mywork.mybatisplus.mapper"})
@MapperScan("com.mywork.mybatisplus.mapper")//如果mapper上边没有加@Mapper注解，在这里添加mapper扫描
public class MybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusApplication.class, args);
    }

}
