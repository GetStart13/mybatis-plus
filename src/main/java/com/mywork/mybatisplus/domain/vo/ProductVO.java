package com.mywork.mybatisplus.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("product p,sys_user u")
public class ProductVO {

    /**
     * 数据直接返回给视图的叫 VO , view object；
     * 如果是从数据库映射给业务层的叫 DTO ，数据传输对象 data transfer object
     */

    @TableField("p.product_name")
    private String productName;
    @TableField("u.username")
    private String username;


    @Override
    public String toString() {
        return "ProductVO{" +
                "productName='" + productName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
