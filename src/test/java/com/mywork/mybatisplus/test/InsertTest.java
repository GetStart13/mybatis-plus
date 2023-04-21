package com.mywork.mybatisplus.test;

import com.mywork.mybatisplus.domain.User;
import com.mywork.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

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
        Assertions.assertEquals(3, (int) integer);
    }
}
