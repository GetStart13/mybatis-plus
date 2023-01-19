package com.mywork.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mywork.mybatisplus.domain.User;
import com.mywork.mybatisplus.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 因为 select 是 mybatis 的东西，但是 ProductVO 又是 mybatisPlus 的东西，所以
     * 两者组合起来就会有问题，因为上边 BaseMapper 的泛型是 User，所以 ProductVO 里的任何 mybatisPlus
     * 注解都不会生效（没有经过 BaseMapper<User> 的处理）但是驼峰命名会转换，所以要
     * 非常注意 ProductVO 里边属性的命名，如果命名不对，会映射不起来，但是查询总会成功，
     * 因为它直接执行 @Select 设置的语句，然后再根据查询结果给 ProductVO 属性赋值
     */

    @Select("select p.product_name product_name,u.username from product p,sys_user u where p.user_id=u.id and u.id=#{id}")
    List<ProductVO> productList(Serializable id);

    List<User> findAll();
}
