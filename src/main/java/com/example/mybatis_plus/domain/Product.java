package com.example.mybatis_plus.domain;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("product")
public class Product {
    private Long id;
    private Long userId;
    private String productName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", userId=" + userId +
                ", productName='" + productName + '\'' +
                '}';
    }
}
