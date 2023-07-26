package com.example.mybatis_plus.service;

import com.example.mybatis_plus.domain.User;

import java.util.List;

public interface UserService {
    List<User> list();

    boolean update(User user);
}
