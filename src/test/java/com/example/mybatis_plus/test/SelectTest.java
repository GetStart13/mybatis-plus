package com.example.mybatis_plus.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_plus.domain.User;
import com.example.mybatis_plus.domain.vo.ProductVo;
import com.example.mybatis_plus.mapper.ProductMapper;
import com.example.mybatis_plus.mapper.UserMapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SelectTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;

    @Test
    void multiTableSelect() {
        // 多表关联查询
        List<ProductVo> productVOS = productMapper.productListByUserId(1);
        productVOS.forEach(System.out::println);
        assertTrue(true);
    }

    @Test
    void testSelectPage() {
        Page<User> userPage = new Page<>(1L, 3L);
        User user = new User();
        user.setAge(24);
        Page<User> selectPage = userMapper.selectPage(userPage, new QueryWrapper<>(user).eq(false, "id", 7));
        System.out.println(selectPage);
        assertNotEquals(null, selectPage);
    }

    @Test
    void testQueryWrapper() {
        Page<User> userPage = new Page<>(1L, 3L);
        User user = new User();
        user.setAge(24);
        Page<User> selectPage = userMapper.selectPage(userPage,
                new LambdaQueryWrapper<>(user)
                        .eq(true, User::getId, 7)
                        .eq(false, User::getName, "谢洪"));
        System.out.println(selectPage);
        assertNotEquals(null, selectPage);

        List<User> users = userMapper.selectList(new QueryWrapper<>(user));
        System.out.println(users);
        assertNotEquals(null, users);
    }

    @Test
    void testNullQueryEntity() {
        List<User> users = userMapper.selectList(new QueryWrapper<>(null));
        System.out.println(users);
        assertFalse(users.isEmpty());
    }

    @Test
    void testLimit() {
        List<User> users = userMapper.selectList(new QueryWrapper<User>().last("limit 3"));
        System.out.println(users);
        assertFalse(users.isEmpty());
    }
}
