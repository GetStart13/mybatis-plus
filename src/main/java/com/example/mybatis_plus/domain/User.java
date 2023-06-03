package com.example.mybatis_plus.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.mybatis_plus.enums.GenderEnum;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

@FieldNameConstants // 编译时生成字段属性常量
@TableName(value = "sys_user", autoResultMap = true)// 指定数据库表名，拼接到 SQL 语句的 from 子句之后
public class User {
    /**
     * 由 MybatisPlus 处理的自增 id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * "@TableField"绑定数据库字段名
     */
    @TableField("username")
    private String name;
    private Integer age;
    /**
     * 枚举
     */
    private GenderEnum gender;
    /**
     * 添加时填充字段
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 添加和修改都填充字段
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    /**
     * 忽略字段映射，一般实体应与数据库一一对应，附加字段在 vo 中定义
     */
    @TableField(exist = false)
    private String ignore;
    /**
     * "@TableLogic" 标记该字段为逻辑删除，需要在配置文件配置逻辑删除字段信息；
     * 自从 3.3.0 之后，有 配置文件 和 注解 两种方式，只需要配置其中一种方式就能够实现逻辑删除
     */
    @TableLogic
    private int isDeleted;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", ignore='" + ignore + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
