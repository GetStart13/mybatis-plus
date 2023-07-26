package com.example.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatis_plus.domain.User;
import com.example.mybatis_plus.mapper.UserMapper;
import com.example.mybatis_plus.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 2023/7/26 </p>
 * 通过继承 ServiceImpl 以使用 mybatis plus 封装好的基本 CRUD 方法
 * <br>
 * 如果不需要暴露过多方法给外部，则在接口层不继承 IService 即可
 *
 * @author Fqq
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public List<User> list() {
        return super.list();
    }

    @Override
    public boolean update(User user) {
        return super.update(user, new LambdaQueryWrapper<User>().eq(User::getId, user.getId()));
    }
}
