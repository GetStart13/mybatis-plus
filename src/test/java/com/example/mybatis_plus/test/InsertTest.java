package com.example.mybatis_plus.test;

import com.example.mybatis_plus.domain.User;
import com.example.mybatis_plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InsertTest {
    @Autowired
    UserMapper userMapper;

    /**
     * 批量插入测试
     */
    @Test
    void addBatchTest() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setName("batch insert " + i);
            users.add(user);
        }
        Integer integer = userMapper.insertBatchSomeColumn(users);
        assertEquals(3, (int) integer);
    }

    @Test
    void returnIdTest() {
        User user = new User();
        user.setName("name");
        int insert = userMapper.insert(user);
        assertTrue(insert > 0);
    }
}
