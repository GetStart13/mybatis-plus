package com.mywork.mybatisplus.test;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.mywork.mybatisplus.domain.User;
import com.mywork.mybatisplus.mapper.UserMapper;
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
        int update = userMapper.update(user, new LambdaUpdateWrapper<User>().eq(User::getId, user.getId()));
        System.out.println(update);
    }
}
