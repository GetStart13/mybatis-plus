package com.example.mybatis_plus.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mybatis_plus.domain.User;
import com.example.mybatis_plus.mapper.UserMapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OtherTest {
    @Autowired
    UserMapper userMapper;

    @Test
    void lambdaWithGetterToGetFieldNameTest() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // 方法引用 User::getName 可以读取到属性名，是因为继承了 Serializable 接口的类会生成 writeReplace 方法，
        // 调用此方法可以得到对象的替换者 SerializedLambda，可以通过它读取到方法引用的方法名
        queryWrapper.eq(User::getName, "lisi");
        List<User> users = userMapper.selectList(queryWrapper);
        assertNotEquals(0, users.size());
    }
}
