package com.example.mybatis_plus.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.LambdaUtils;
import com.baomidou.mybatisplus.core.toolkit.support.LambdaMeta;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.core.toolkit.support.SerializedLambda;
import com.baomidou.mybatisplus.core.toolkit.support.ShadowLambdaMeta;
import com.example.mybatis_plus.domain.User;
import com.example.mybatis_plus.mapper.UserMapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OtherTest {

    private static final Logger log = LoggerFactory.getLogger(OtherTest.class);

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

    @Test
    void utilTest() {
        LambdaMeta extract = LambdaUtils.extract(Customer::getName);
        String methodName = extract.getImplMethodName();
        log.info("method reference name: {}", methodName);
        assertEquals("getName", methodName);
    }

    @Test
    void serializeExtractTest() {
        ShadowLambdaMeta shadowLambdaMeta = new ShadowLambdaMeta(SerializedLambda.extract(
            (SFunction<Customer, String>) Customer::getName));
        String methodName = shadowLambdaMeta.getImplMethodName();
        log.info("method reference name: {}", methodName);
        assertEquals("getName", methodName);
    }

    static class Customer {
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
