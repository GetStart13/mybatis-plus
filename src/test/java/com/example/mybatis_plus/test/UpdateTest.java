package com.example.mybatis_plus.test;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.mybatis_plus.domain.User;
import com.example.mybatis_plus.mapper.UserMapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UpdateTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据条件更新实体，
     * 实体更新默认去除了空值
     */
    @Test
    void testUpdateEntity() {
        User user = new User();
        user.setId(9L);
        user.setName("周明");
        user.setAge(null);
        // Wrapper 用于追加条件语句，set 实体放在 Wrapper 中不能自动 set 值，只会追加 where 语句
        int update = userMapper.update(user, new LambdaUpdateWrapper<User>().eq(User::getId, user.getId()));
        System.out.println(update);
        assertNotEquals(0, update);
    }
}
