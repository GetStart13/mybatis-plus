package com.example.mybatis_plus.domain.vo;

import com.example.mybatis_plus.domain.Product;

/**
 * <p> 2023/6/3 </p>
 * 一个用户对应多个产品
 * <br> 数据直接返回给视图的叫 vo，view object；
 * <br> 如果是从数据库映射给业务层的叫 dto，数据传输对象 data transfer object
 *
 * @author Fqq
 */
public class ProductVo extends Product {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ProductVo{" +
                "username='" + username + '\'' +
                "} " + super.toString();
    }
}
