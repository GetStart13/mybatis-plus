package com.example.mybatis_plus.domain;

/**
 * <p> 2023/6/3 </p>
 * 学生表，与用户表一对一的映射关系
 *
 * @author Fqq
 */
public class StudentInfo {
    private Long id;
    private Long userId;
    private String studentNumber;
    private String studentName;

    public StudentInfo() {
    }

    public StudentInfo(Long userId, String studentNumber, String studentName) {
        this.id = id;
        this.userId = userId;
        this.studentNumber = studentNumber;
        this.studentName = studentName;
    }

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

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
