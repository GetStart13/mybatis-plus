package com.mywork.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;

import java.util.List;

/**
 * <p> 2023/4/21 </p>
 * 批量插入数据：
 * 1、继承 默认SQL注入 类，重写 getMethodList 方法
 * 2、在配置类中将 SQL注入类(BatchValuesInsert) 注入到 spring bean 容器
 * 3、自定义 mapper 继承 BaseMapper，添加方法 Integer insertBatchSomeColumn(List<T> entityList);
 * 4、实体 mapper 继承 自定义批量插入的 mapper
 * 5、调用批量注入方法 insertBatchSomeColumn 批量插入数据
 *
 * @author Fqq
 */
public class BatchValuesInsert extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
        methodList.add(new InsertBatchSomeColumn(v -> v.getFieldFill() != FieldFill.UPDATE));
        return methodList;
    }
}
