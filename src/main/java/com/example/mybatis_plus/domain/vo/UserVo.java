package com.example.mybatis_plus.domain.vo;

import com.example.mybatis_plus.domain.StudentInfo;
import com.example.mybatis_plus.domain.User;

import java.util.List;

public class UserVo extends User {
    /**
     * 一对多查询，通过 mybatis xml 方式实现
     */
    private List<ProductVo> buys;
    /**
     * 与学生表一对一的映射关系
     */
    private StudentInfo studentInfo;

    public List<ProductVo> getBuys() {
        return buys;
    }

    public void setBuys(List<ProductVo> buys) {
        this.buys = buys;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "buys=" + buys +
                ", studentInfo=" + studentInfo +
                "} " + super.toString();
    }
}
