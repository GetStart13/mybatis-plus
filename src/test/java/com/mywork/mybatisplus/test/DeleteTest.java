package com.mywork.mybatisplus.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mywork.mybatisplus.domain.User;
import com.mywork.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeleteTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void deleteConditionTest() {
        int delete = userMapper.delete(new LambdaQueryWrapper<User>().eq(User::getName, "drift-bottle"));
        Assertions.assertTrue(delete >= 0);
    }
}
