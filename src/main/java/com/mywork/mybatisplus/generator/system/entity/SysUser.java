package com.mywork.mybatisplus.generator.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 *
 * </p>
 *
 * @author fqq
 * @since 2021-11-29
 */
@TableName("sys_user")
//@ApiModel(value = "SysUser对象", description = "")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private String username;

    private Integer delStatus;

    private Integer gender;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


    public Long getId() {
        return id;
    }

      public void setId(Long id) {
          this.id = id;
      }

    public String getUsername() {
        return username;
    }

      public void setUsername(String username) {
          this.username = username;
      }

    public Integer getDelStatus() {
        return delStatus;
    }

      public void setDelStatus(Integer delStatus) {
          this.delStatus = delStatus;
      }

    public Integer getGender() {
        return gender;
    }

      public void setGender(Integer gender) {
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

    @Override
    public String toString() {
        return "SysUser{" +
              "id=" + id +
                  ", username=" + username +
                  ", delStatus=" + delStatus +
                  ", gender=" + gender +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
              "}";
    }
}
