package com.mywork.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mywork.mybatisplus.domain.User;
import com.mywork.mybatisplus.domain.vo.ProductVO;

import com.mywork.mybatisplus.enums.GenderEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class sysuserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void findAll() {
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void insert() {
        User user = new User();
        user.setName("王五");
        user.setGender(GenderEnum.WOMAN);
        userMapper.insert(user);
    }

    @Test
    void del() {
        userMapper.deleteById(4);
    }

    @Test
    void select() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("username", "谢洪");//多条件查询
        map.put("del_status", 0);
        wrapper.allEq(map);
        System.out.println(userMapper.selectList(wrapper));
//        wrapper.ge("age",23);//大于或等于 : greater and equals
//        wrapper.lt("age",23);//小于等于 : less than
//        wrapper.likeLeft("name","小");//模糊查询，语句为： %小

        //联合查询，in子查询
//        wrapper.inSql("age","这里写sql语句");
//        wrapper.inSql("id","这里写sql语句");
    }

    @Test
    void pageSelect() {
        //分页查询，current当前页，size每页条数
        IPage<User> page = new Page<>(2, 2);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        userIPage.getRecords().forEach(System.out::println);
    }

    @Test
    void SelectVO() {
        //多表关联查询
        List<ProductVO> productVOS = userMapper.productList(1);
        productVOS.forEach(System.out::println);
    }

    @Test
    void update() {
        User user = new User();
        user.setName("李云龙");
        user.setId(6L);
        user.setIgnore("不需要映射的字段");
        userMapper.updateById(user);
    }

    //查询语句字符串拼接:
    @Autowired
    private VOMapper voMapper;

    @Test
    void voTest() {
        QueryWrapper<ProductVO> wrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("p.user_id=u.id and 1", 1);
        map.put("u.id", 1);
        wrapper.allEq(map);
        System.out.println(voMapper.selectList(wrapper));
    }
    //
}
