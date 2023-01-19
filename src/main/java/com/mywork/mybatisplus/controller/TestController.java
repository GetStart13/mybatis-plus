package com.mywork.mybatisplus.controller;

import com.mywork.mybatisplus.domain.User;
import com.mywork.mybatisplus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mybatis_plus")
public class TestController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/list")
    public ResponseEntity<Object> findAll() {
        List<User> all = userMapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        return ResponseEntity.ok("访问成功了!");
    }
}
