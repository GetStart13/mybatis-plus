package com.mywork.mybatisplus.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mywork.mybatisplus.domain.User;
import com.mywork.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestSelect {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelectPage() {
        Page<User> userPage = new Page<>(1L, 3L);
        User user = new User();
        user.setAge(24);
        Page<User> selectPage = userMapper.selectPage(userPage, new QueryWrapper<>(user).eq(false, "id", 7));
        System.out.println(selectPage);
    }

    @Test
    void testLambdaQueryWrapper() {
        Page<User> userPage = new Page<>(1L, 3L);
        User user = new User();
        user.setAge(24);
        Page<User> selectPage = userMapper.selectPage(userPage, new LambdaQueryWrapper<>(user).eq(true, User::getId, 7));
        System.out.println(selectPage);
    }
}
