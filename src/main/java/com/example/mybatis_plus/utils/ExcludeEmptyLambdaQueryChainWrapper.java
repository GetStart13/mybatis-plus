package com.example.mybatis_plus.utils;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;

import java.util.Objects;

/**
 * 2022/11/12
 * <br> 不拼接空值的条件查询
 * <br> lambda 链式 构造器不能被当做普通构造器传入方法中，请使用它本身的链式表达式完成数据库操作
 *
 * @author Fqq
 */
public class ExcludeEmptyLambdaQueryChainWrapper<T> extends LambdaQueryChainWrapper<T> {
    public ExcludeEmptyLambdaQueryChainWrapper(BaseMapper<T> baseMapper) {
        super(baseMapper);
    }

    /**
     * @param val 查询条件 值
     * @return 条件是否为空
     * <br>
     * 2022/11/12 13:15
     * 条件为空则不执行
     */
    private static boolean excludeEmpty(Object val) {
        if (val instanceof String) {
            return !(StringUtils.isBlank((String) val));
        }
        return !(Objects.isNull(val));
    }

    @Override
    public LambdaQueryChainWrapper<T> likeRight(SFunction<T, ?> column, Object val) {
        return super.likeRight(excludeEmpty(val), column, val);
    }

    @Override
    public LambdaQueryChainWrapper<T> eq(SFunction<T, ?> column, Object val) {
        return super.eq(excludeEmpty(val), column, val);
    }
}
