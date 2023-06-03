package com.example.mybatis_plus.utils;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.mybatis_plus.domain.User;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 自动填充
     * 添加时会给下面两个字段设值
     */
    @Override
    public void insertFill(MetaObject metaObject) {

        this.strictInsertFill(metaObject, User.Fields.createTime, LocalDateTime::now, LocalDateTime.class)
                .strictInsertFill(metaObject, User.Fields.updateTime, LocalDateTime::now, LocalDateTime.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, User.Fields.updateTime, LocalDateTime::now, LocalDateTime.class);
    }
}
