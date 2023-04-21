package com.mywork.mybatisplus.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mywork.mybatisplus.domain.User;
import com.mywork.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        Assertions.assertNotEquals(null, selectPage);
    }

    @Test
    void testQueryWrapper() {
        Page<User> userPage = new Page<>(1L, 3L);
        User user = new User();
        user.setAge(24);
        Page<User> selectPage = userMapper.selectPage(userPage, new LambdaQueryWrapper<>(user).eq(true, User::getId, 7));
        System.out.println(selectPage);
        Assertions.assertNotEquals(null, selectPage);

        List<User> users = userMapper.selectList(new QueryWrapper<>(user));
        System.out.println(users);
        Assertions.assertNotEquals(null, users);
    }
}
