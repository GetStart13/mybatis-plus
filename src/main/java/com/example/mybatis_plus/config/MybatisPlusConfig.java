package com.example.mybatis_plus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis plus 配置
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * mybatis plus 分页插件配置
     * <br> 注入分页配置 bean 后，使用 mybatis-plus 的分页查询功能可以识别分页参数
     * <br> 若无分页配置，分页查询的分页参数无效
     *
     * @return bean
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /**
     * 批量插入配置
     */
    @Bean
    public BatchValuesInsert batchValuesInsert() {
        return new BatchValuesInsert();
    }
}
