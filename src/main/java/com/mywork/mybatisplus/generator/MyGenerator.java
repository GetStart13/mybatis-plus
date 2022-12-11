package com.mywork.mybatisplus.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import java.util.Collections;

public class MyGenerator {
    /**
     * 快速生成代码
     */
    public static void main(String[] args) {
        FastAutoGenerator
                // 数据库配置
                .create("jdbc:mysql://localhost:3306/mybatis_plus", "root", "123456")
                .globalConfig(builder -> builder.author("fqq") // 设置作者
                        .enableSwagger() // 开启 swagger 模式
                        .fileOverride() //覆盖已生成文件
                        // 生成包 项目目录 + 项目下具体目录 ↓
                        .outputDir(System.getProperty("user.dir") + "/src/main/java")
                )
                .packageConfig(builder -> //包配置
                        builder.parent("com.mywork.mybatisplus.generator") // 生成包的父包名
                                .moduleName("system") //父包模块名
                                // 设置 mapper.xml 生成路径
                                .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir")
                                        + "/src/main/java/aMapper"))
                )
                .strategyConfig(builder ->
                        builder.addInclude("sys_user") // 需要生成的表，包括
                )
                //.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute(); // 执行 !
    }

}
