package com.mywork.mybatisplus.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.mywork.mybatisplus.enums.GenderEnum;

import java.time.LocalDateTime;

@TableName("sys_user")// 指定数据库表名
public class User {
    @TableId(type = IdType.AUTO)// 由 MybatisPlus 处理的自增 id
    private Long id;

    @TableField("username")// 绑定数据库字段名
    private String name;

    @TableLogic// 设置逻辑删除，需要在配置文件配置信息，since 3.3.0,配置后可以忽略不配置实体属性 @TableLogic 注解
    private int delStatus;

    private GenderEnum gender;// 枚举

    @TableField(fill = FieldFill.INSERT)// 添加时填充字段
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)// 添加和修改都填充字段
    private LocalDateTime updateTime;

    @TableField(exist = false) // 忽略字段映射
    private String ignore;


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

    public int getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(int delStatus) {
        this.delStatus = delStatus;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", delStatus=" + delStatus +
                ", gender=" + gender +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
