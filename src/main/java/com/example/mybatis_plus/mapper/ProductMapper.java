package com.example.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis_plus.domain.Product;
import com.example.mybatis_plus.domain.vo.ProductVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface ProductMapper extends BaseMapper<Product> {
    /**
     * 由于 select 是 mybatis 的设计，但是 list 泛型 ProductVo 又是 mybatisPlus 的设计，所以两者组合起来就会有问题，
     * 由于上边 BaseMapper 的泛型是 User，所以 ProductVo 里的任何属于 mybatisPlus 的注解都不会生效（没有经过 BaseMapper<User> 的处理）
     * 但是驼峰命名会转换，所以需要注意 ProductVo 实体属性的命名，如果命名不对，将导致映射不对，但是查询总会成功，
     * 因为它直接执行 @Select 设置的语句，然后再根据查询结果给 ProductVo 属性赋值
     */
    @Select("select p.product_name,u.username from product p,sys_user u where p.user_id=u.id and u.id=#{id}")
    List<ProductVo> productListByUserId(Serializable id);
}
