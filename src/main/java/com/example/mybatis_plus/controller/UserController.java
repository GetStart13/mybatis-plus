package com.example.mybatis_plus.controller;

import com.example.mybatis_plus.domain.User;
import com.example.mybatis_plus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 返回前端时将拿到被 @JsonValue 标记的枚举字段值
     *
     * @return 用户列表
     */
    @GetMapping("/list")
    public ResponseEntity<List<User>> list() {
        return ResponseEntity.ok(userService.list());
    }

    /**
     * 前端传入值时将根据 @JsonValue 标记的枚举字段映射得到枚举
     *
     * @param user 用户
     * @return 更新结果
     */
    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody User user) {
        boolean result = userService.update(user);
        return result ? ResponseEntity.ok("success") : new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
    }
}
