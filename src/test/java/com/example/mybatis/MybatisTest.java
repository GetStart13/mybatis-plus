package com.example.mybatis;

import com.example.mybatis_plus.MybatisPlusApplication;
import com.example.mybatis_plus.domain.StudentInfo;
import com.example.mybatis_plus.domain.vo.UserVo;
import com.example.mybatis_plus.mapper.StudentInfoMapper;
import com.example.mybatis_plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = MybatisPlusApplication.class)
class MybatisTest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    StudentInfoMapper studentInfoMapper;

    /**
     * 联表查询
     */
    @Test
    void getUserVoById() {
        UserVo userVoById = userMapper.getUserVoById(1L);
        assertNotNull(userVoById);
    }

    /**
     * xml 使用 where 标签
     */
    @Test
    void findAllStudentInfo() {
        StudentInfo studentInfo = new StudentInfo(2L, null, null);
        List<StudentInfo> all = studentInfoMapper.findAllForXml(studentInfo);
        assertNotNull(all);
    }

    /**
     * 使用 trim 标签
     */
    @Test
    void insertStudentInfo() {
        StudentInfo studentInfo = new StudentInfo(15L, "10086", "神农");
        int count = studentInfoMapper.insertForXml(studentInfo);
        System.out.println(studentInfo);
        assertTrue(count >= 0);
    }

    /**
     * 使用 set 标签
     */
    @Test
    void updateStudentInfo() {
        StudentInfo studentInfo = new StudentInfo(null, "886", "武则天");
        studentInfo.setId(3L);
        int count = studentInfoMapper.updateByIdForXml(studentInfo);
        assertTrue(count >= 0);
    }

    /**
     * 使用 foreach 标签
     */
    @Test
    void insertBatchStudentInfo() {
        ArrayList<StudentInfo> studentInfos = new ArrayList<>();
        int maxUserId = studentInfoMapper.getMaxUserId();
        for (int i = maxUserId + 1; i < maxUserId + 3; i++) {
            StudentInfo studentInfo = new StudentInfo((long) i, "s" + i, "name: " + i);
            studentInfos.add(studentInfo);
        }
        int count = studentInfoMapper.insertBatchForXml(studentInfos);
        assertTrue(count > 0);
    }

    /**
     * 验证 #{} 和 ${} 的表达式区别
     */
    @Test
    void foreachArrayTest() {
        Object[] longs = {13L, "s106", "李世民"};
        ArrayList<Object[]> list = new ArrayList<>();
        list.add(longs);
        int studentInfos = studentInfoMapper.insertBatchUseArrayForXml(list);
        assertTrue(studentInfos > 0);
    }

}
