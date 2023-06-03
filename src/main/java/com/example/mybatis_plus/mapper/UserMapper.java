package com.example.mybatis_plus.mapper;

import com.example.mybatis_plus.domain.User;
import com.example.mybatis_plus.domain.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BatchInsertUserMapper<User> {

    List<User> findAll();

    /**
     * 联表查询
     *
     * @param userId 用户id
     * @return 联表查询结果
     */
    UserVo getUserVoById(Long userId);
}
