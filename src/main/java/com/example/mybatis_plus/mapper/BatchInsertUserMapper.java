package com.example.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p> 2023/4/21 </p>
 * 批量插入 mapper 配置
 *
 * @author Fqq
 */
public interface BatchInsertUserMapper<T> extends BaseMapper<T> {
    /**
     * 批量插入的方法，只适用于 mysql
     * 方法名字似乎不能随便更改
     *
     * @param entityList 实体列表
     * @return 影响行数
     */
    Integer insertBatchSomeColumn(List<T> entityList);
}
