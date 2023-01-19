package com.mywork.mybatisplus;

import com.mywork.mybatisplus.generator.system.controller.SysUserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Set;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Test
    void contextLoads() {
    }

    // 测试controller
    @Autowired
    private SysUserController controller;
    @Test
    void testController(){
        ModelAndView modelAndView = controller.userList();
        Map<String, Object> model = modelAndView.getModel();
        Set<Map.Entry<String, Object>> entries = model.entrySet();
        entries.forEach(System.out::println);
    }
}
