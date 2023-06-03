package com.example.mybatis_plus.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mybatis_plus.domain.User;
import com.example.mybatis_plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeleteTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void deleteConditionTest() {
        int delete = userMapper.delete(new LambdaQueryWrapper<User>().eq(User::getName, "drift-bottle"));
        assertTrue(delete >= 0);
    }
}
